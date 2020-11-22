package image.crystalapps.kecommerce

import  android.app.Activity
import android.app.Instrumentation
import android.content.Intent
import android.os.Bundle
import androidx.test.espresso.intent.Intents.intended
import androidx.test.filters.LargeTest
import androidx.test.espresso.intent.rule.IntentsTestRule


import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.intent.Intents.intending
import androidx.test.espresso.intent.matcher.IntentMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import image.crystalapps.kecommerce.ui.productselection.ProductSelectionActivity


@RunWith(AndroidJUnit4::class)
class TestingActivityTest {


    @get:Rule
    val intentRule : IntentsTestRule<ProductSelectionActivity> = IntentsTestRule(ProductSelectionActivity::class.java)

    @Before
    fun  before(){
        val intents=       createImageCaptureActivityResultStub()
        intending(hasExtraWithKey("parcel")).respondWith(intents)
    }

    @Test
    fun checkActivityTest(){

        intended(hasExtra("parcel" ,"Testing"))
    }

    private fun createImageCaptureActivityResultStub() : Instrumentation.ActivityResult{
        val bundle = Bundle()
        bundle.putString("parcel" ,"Testing")
        val intent = Intent()
        intent.putExtras(bundle)
        return Instrumentation.ActivityResult(Activity.RESULT_OK ,intent) }



}