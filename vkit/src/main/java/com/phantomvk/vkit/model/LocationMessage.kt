package com.phantomvk.vkit.model

/**
 * The message of the location.
 *
 * @param name The name of the location.
 */
class LocationMessage(var name: String, url: String) : Message(MESSAGE_TYPE_URL, url) {
    /**
     * The map image of the location, optional.
     */
    var image: String? = null

    /**
     * The address of the location.
     */
    var address: String? = null
}
