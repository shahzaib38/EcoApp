package image.crystalapps.kecommerce.data.network.firebase

import image.crystalapps.kecommerce.model.Address
import image.crystalapps.kecommerce.model.NotificationBean

interface ServerFunctions {

    fun registerInstanceId(instanceId: String)
    fun sendNotification(notification : NotificationBean)

    fun save(address :Address)






}