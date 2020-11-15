package image.crystalapps.kecommerce.ui.productactivity

import android.net.Uri
import android.os.Bundle
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import image.crystalapps.kecommerce.ext.launchFragmentInHiltContainer
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes
import image.crystalapps.kecommerce.ui.productselection.ProductSelectionActivity
import image.crystalapps.kecommerce.ui.productselection.fragments.PagerFragment
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class PagerFragmentTest {




    @get:Rule
    val hiltRule= HiltAndroidRule(this)


    @Before
    fun initDataManager(){
        hiltRule.inject()
    }


    @Test
    fun checkIfProductBundleIsparceled(){


        val bundle =Bundle()
        bundle.putParcelable(PagerFragment.PRODUCTS ,getProducts())
        launchFragmentInHiltContainer<PagerFragment>(bundle)
    }


    private fun getProducts() : Products {
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

        val uriArray =ArrayList<String>()
        uriArray.add(uri.toString())
//        uriArray.add(uri.toString())
        //      uriArray.add(uri.toString())

        val products= Products(
            "Jeans",
            "men",
            "Black T Shirt",
            "12",
            4,
            "1.33",
            "SM22446",
            uriArray,
            "Black T -shirt with design",
            12200,
            productDetails)
        return products }

}



