package image.crystalapps.kecommerce.data.network.firebase

import image.crystalapps.kecommerce.model.NotificationBean
import image.crystalapps.kecommerce.ui.base.BaseRepository
import javax.inject.Singleton

@Singleton
class AppLevelRepository private constructor(val serverFunctions: ServerFunctions) :BaseRepository()  , ServerFunctions by serverFunctions {


    override fun registerInstanceId(instanceId: String) {
        serverFunctions.registerInstanceId(instanceId) }


    override fun sendNotification(notification: NotificationBean) {

        serverFunctions.sendNotification(notification)
    }

    companion object {

        @Volatile
        private var INSTANCE: AppLevelRepository? = null

        fun getInstance(
            serverFunctions: ServerFunctions
        ): AppLevelRepository =
            INSTANCE ?: synchronized(this) {
                INSTANCE ?:
                AppLevelRepository(serverFunctions)
                    .also { INSTANCE = it }
            }
    }








}