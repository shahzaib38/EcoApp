package image.crystalapps.kecommerce.broadcast

import android.content.Context
import android.content.Intent
import android.util.Log
import dagger.android.DaggerBroadcastReceiver
import javax.inject.Inject

class BaseBroadCastReciever @Inject constructor(): DaggerBroadcastReceiver() {


    override fun onReceive(context: Context?, intent: Intent?) {
        super.onReceive(context, intent)

        Log.i("test" ,"wokring broadd")


    }



}