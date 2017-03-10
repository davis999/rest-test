package io.reactivesw.category

import io.reactivesw.category.config.CategoryConfig
import io.reactivesw.category.data.DataFactory
import io.reactivesw.util.CleanupMap
import io.reactivesw.util.CleanupUtil
import io.reactivesw.util.RestClientFactory
import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by Davis on 17/3/10.
 */
class UpdateTest extends Specification {
    @Shared
    def id
    @Shared
    def version
    @Shared
    def category
    @Shared
    def primerEndpoint
    @Shared
    CleanupMap cleanupMap = new CleanupMap()

    def setupSpec() {
        category = DataFactory.getCategory()
        primerEndpoint = RestClientFactory.getJsonClient(CategoryConfig.rootURL)
        def response = primerEndpoint.post(body: category)
        id = response.data.id
        version = response.data.version
        cleanupMap.addObject(response.data.id, response.data.version)
    }

    def "test 1 : update category name"() {
        given: "prepare data"
        def setName = DataFactory.getSetNameAction()
        setName['version'] = cleanupMap.allObjects[id]

        when: "call api to update category name"
        primerEndpoint
        def response = primerEndpoint.put([path: id, body: setName])

        then: "success, return 200 and category with new name"
        cleanupMap.addObject(response.data.id, response.data.version)
        response.status == 200
        response.data.name == setName.actions[0].name

    }

    def "test 2 : update category slug"() {
        given: "prepare data"
        def setSlug = DataFactory.getSetSlugAction()
        setSlug['version'] = cleanupMap.allObjects[id]

        when: "call api to update category slug"
        primerEndpoint
        def response = primerEndpoint.put([path: id, body: setSlug])

        then: "success, return 200 and category with new slug"
        cleanupMap.addObject(response.data.id, response.data.version)
        response.status == 200
        response.data.slug == setSlug.actions[0].slug

    }

    def cleanupSpec() {
        CleanupUtil.cleanup(CategoryConfig.rootURL, cleanupMap)
    }
}
