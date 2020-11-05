package image.crystalapps.kecommerce.ui.productactivity

import android.content.Intent
import android.net.Uri
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import image.crystalapps.kecommerce.ui.productselection.ProductSelectionActivity
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.rule.ActivityTestRule
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ProductActivityTest {


    @get:Rule
    val hiltRule= HiltAndroidRule(this)

    @get:Rule
    val activityRule  :ActivityTestRule<ProductSelectionActivity>  =ActivityTestRule<ProductSelectionActivity>(ProductSelectionActivity::class.java ,false ,false)


    @Before
    fun initDataManager(){
        hiltRule.inject() }

    @Test
     fun checkProductIntentAtBeginning(){
        val intent =createProductIntent()
        activityRule.launchActivity(intent)
    }

    @Test
    fun checkProductPriceTextViewContent(){

        activityRule.launchActivity(createProductIntent())
        onView(withId(R.id.product_price)).check(matches(isDisplayed()))
        onView(withId(R.id.product_price)).check(matches(withText("Product Price")))
        onView(withId(R.id.product_price)).check(matches(ViewMatchers.withEffectiveVisibility(Visibility.VISIBLE)))


    }

    @Test
    fun checkRecyclerviewContent(){


    }



        private fun createProductIntent() :Intent{

        val uri1: Uri = Uri.parse("android.resource://image.crystalapps.kecommerce/drawable/jeans")
        val varietiesArray=ArrayList<Sizes>()
        val varietiesArray1=ArrayList<Sizes>()

        val varieties=  Sizes("" ,uri1.toString())
        val varieties1=  Sizes("S",null)
        val varieties2=  Sizes("M",null)
        val varieties3=  Sizes("L",null)
        val varieties4=  Sizes("XL",null)

        varietiesArray.add(varieties)
        varietiesArray1.add(varieties1)
        varietiesArray1.add(varieties2)
        varietiesArray1.add(varieties3)
        varietiesArray1.add(varieties4)

        val productDetails=ArrayList<ProductsDetails>()
        val productsDetailsItem1 = ProductsDetails("Varietes",varietiesArray )
        val productsDetailsItem2 = ProductsDetails("sizes",varietiesArray1 )

        productDetails.add(productsDetailsItem1)
        productDetails.add(productsDetailsItem2)

        val uri: Uri = Uri.parse("android.resource://image.crystalapps.kecommerce/drawable/jeans")
        val products= Products("men", "Black T Shirt", "12", 4, "1.33", "SM22446", uri.toString(), "Black T -shirt with design", 12200, productDetails)
        val intent  =Intent()
        intent.putExtra("parcel",products)
        return intent
    }


}