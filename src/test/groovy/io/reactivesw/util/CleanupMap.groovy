package io.reactivesw.util

import sun.java2d.opengl.OGLContext

/**
 * Created by Davis on 17/3/9.
 */
class CleanupMap {
    private Map<String, Integer> objects

    CleanupMap() {
        this.objects = new HashMap<>()
    }

    public void addObject(String id, Integer version) {
        objects.put(id, version)
    }

    public Map getAllObjects() {
        return this.objects
    }

//    public static void main(String[] args) {
//        CleanupMap cleanupMap = new CleanupMap()
//        cleanupMap.addObject("111111", 1)
//        cleanupMap.addObject("1111112", 3)
//        println(cleanupMap.getAllObjects())
//
//        cleanupMap.getAllObjects().each { key, value ->
//            println(key)
//            println(value)
//        }
//    }
}
