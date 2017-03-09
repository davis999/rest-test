package io.reactivesw.util

/**
 * Created by Davis on 17/3/9.
 */
class CleanupObject {
    String id
    Integer version

    CleanupObject() {
    }

    CleanupObject(String id, Integer version) {
        this.id = id
        this.version = version
    }
}
