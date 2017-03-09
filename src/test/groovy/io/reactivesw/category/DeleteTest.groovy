package io.reactivesw.category

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import io.reactivesw.category.config.CategoryConfig
import io.reactivesw.category.data.DataFactory
import io.reactivesw.util.RestClientFactory
import spock.lang.Specification

/**
 * Created by Davis on 17/3/9.
 */
class DeleteTest extends Specification {

    def id;
    def version;
    def primerEndpoint

    def setup() {
        def category = DataFactory.getCategory()
        primerEndpoint = RestClientFactory.getJsonClient(CategoryConfig.rootURL)
        def response = primerEndpoint.post(body: category)
        id = response.data.id
        version = response.data.version
    }

    def "test 1 : delete category with id and version, should return 200 and success"() {
        given: "prepare data"
        def deleteURL = CategoryConfig.rootURL + id
        primerEndpoint = RestClientFactory.getClient(deleteURL)
        def version = ['version': version]

        when: "call api"
        def response = primerEndpoint.delete(query: version)

        then: "response status should be 200"
        response.status == 200
    }
}
