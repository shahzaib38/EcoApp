package image.crystalapps.kecommerce.data

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

import dagger.hilt.android.HiltAndroidApp
import image.crystalapps.kecommerce.data.database.local.NotificationDataBase
import image.crystalapps.kecommerce.data.network.firebase.AppLevelRepository
import image.crystalapps.kecommerce.data.network.firebase.ServerFunctions
import image.crystalapps.kecommerce.data.network.firebase.ServerFunctionsImpl
import javax.inject.Inject


@HiltAndroidApp
class  ClientApplication  : Application(){

    @Inject
    lateinit var dataManager: DataManager

    val serverFunctions =ServerFunctionsImpl()

    val app : AppLevelRepository get() = AppLevelRepository.getInstance(serverFunctions)


    override fun onCreate() {
        super.onCreate()
        setUpFresco() }

   private fun setUpFresco(){ Fresco.initialize(this)}

    val dataBase :NotificationDataBase = NotificationDataBase.getInstance(applicationContext)




}