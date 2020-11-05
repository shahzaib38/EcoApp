package image.crystalapps.kecommerce.data

import android.app.Application

import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@HiltAndroidApp
class  ClientApplication  : Application(){

    @Inject
    lateinit var dataManager: DataManager

    override fun onCreate() {
        super.onCreate()
    }

}