package io.reactivesw.category.data

/**
 * Created by Davis on 17/3/9.
 */
class DataFactory {
    public static def getCategory() {
        return ['name': ['en': "category1"], 'slug': "category-slug1"]
    }

    public static def getCategoryWithAllParams() {
        return ['name'           : [
                'de': "de-smartphone_with_all_properties",
                'en': "en-smartphone_with_all_properties"
        ],
         'slug'           : "en-smartphone_slug_with_all_properties",
         'parent'         : [
                 'typeId': "category",
                 'id'    : ''
         ],
         'description'    : [
                 'en': "en-Smartphone is more and more popular in world",
                 'de': "de-Smartphone is more and more popular in world"
         ],
         'orderHint'      : "0.0003148112303713502170356",
         'externalId'     : "1234567890QWERTYUIOP",
         'metaTitle'      : [
                 'en': "en-smartphone",
                 'de': "de-smartphone"
         ],
         'metaDescription': [
                 'en': "en-Smartphone is more and more popular in world",
                 'de': "de-Smartphone is more and more popular in world"
         ],
         'metaKeywords'   : [
                 'en': "en-phone'",
                 'de': "de-phone"
         ]
        ]
    }
}
