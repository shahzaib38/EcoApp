package image.crystalapps.kecommerce.data

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject


@HiltAndroidApp
class  ClientApplication  : Application(){

    @Inject
    lateinit var dataManager: DataManager

    override fun onCreate() {
        super.onCreate()
        setUpFresco() }

   private fun setUpFresco(){ Fresco.initialize(this)}

}