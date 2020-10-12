package image.crystalapps.kecommerce.services

import android.content.Intent
import android.util.Log
import dagger.android.DaggerIntentService
import javax.inject.Inject

class BaseIntentService @Inject constructor()   : DaggerIntentService("BaseIntentSeervice") {



    override fun onCreate() {
        super.onCreate()
    }

    override fun onHandleIntent(intent: Intent?) {

        Log.i("test" ,"woorking")

    }



}