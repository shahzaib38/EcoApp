package image.crystalapps.kecommerce

import android.app.Activity
import android.os.Bundle

class TestingActivity: Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)


        intent.getStringExtra("parcel")



    }








}