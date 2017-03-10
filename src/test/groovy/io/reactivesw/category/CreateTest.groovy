package io.reactivesw.category

import io.reactivesw.category.config.CategoryConfig
import io.reactivesw.category.data.DataFactory
import io.reactivesw.util.CleanupMap
import io.reactivesw.util.CleanupUtil
import io.reactivesw.util.RestClientFactory
import spock.lang.Shared
import spock.lang.Specification

/**
 * Created by Davis on 17/3/9.
 */
class CreateTest extends Specification {
    @Shared
    CleanupMap cleanupMap = new CleanupMap()

    def primerEndpoint = RestClientFactory.getJsonClient(CategoryConfig.rootURL)

    def "test 1 : create category with name and slug, should return 200 and new category"() {
        given: "prepare category data"

        def category = DataFactory.getCategory()

        when: "call category api to create category"
        def response = primerEndpoint.post(body: category)

        then: "response status should be 200, name and slug should be equal to given category"

        response.status == 200
        response.data.name == category.name
        response.data.slug == category.slug

        cleanupMap.addObject(response.data.id, response.data.version)
    }

    def "test 2 : create category with all parmas, should return 200 and new category"() {
        given: "prepare category data"
        def category = DataFactory.getCategoryWithAllParams()

        when: "call category api to create category"
        def response = primerEndpoint.post(body: category)

        then: "response status should be 200, params should be equal to given category"
        response.status == 200
        def newCategory = response.data
        category.name == newCategory.name
        category.slug == newCategory.slug
        category.description == newCategory.description
        category.externalId == newCategory.externalId
        category.metaDescription == newCategory.metaDescription
        category.metaKeywords == newCategory.metaKeywords
        category.metaTitle == newCategory.metaTitle
        category.orderHint == newCategory.orderHint

        cleanupMap.addObject(response.data.id, response.data.version)
    }

    def cleanupSpec() {
        def url = "http://35.184.19.183/categories/"
        CleanupUtil.cleanup(url, cleanupMap)
    }
}
