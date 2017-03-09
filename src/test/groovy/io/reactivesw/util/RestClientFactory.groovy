package io.reactivesw.util

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient
import io.reactivesw.category.config.CategoryConfig

/**
 * Created by Davis on 17/3/9.
 */
class RestClientFactory {
    public static def getJsonClient(String url) {
        def client = new RESTClient(url)
        client.contentType = ContentType.JSON
        return client
    }

    public static def getClient(String url) {
        return new RESTClient(url)
    }
}
