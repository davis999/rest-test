package io.reactivesw.category.data

/**
 * Created by Davis on 17/3/9.
 */
class DataFactory {

    static def slurper = new groovy.json.JsonSlurper()

    public static def getCategory() {

        return slurper.parse(new FileReader('src/test/groovy/io/reactivesw/category/data/Category.json'))
    }

    public static def getCategoryWithAllParams() {
        return slurper.parse(new FileReader('src/test/groovy/io/reactivesw/category/data/CategoryWithAllParams.json'))
    }
}
