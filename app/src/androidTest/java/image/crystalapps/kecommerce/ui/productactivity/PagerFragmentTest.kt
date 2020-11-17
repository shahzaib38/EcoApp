package image.crystalapps.kecommerce.ui.productactivity

import android.net.Uri
import android.os.Bundle
import android.view.View
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
import kotlinx.android.synthetic.main.pager_layout.*
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito


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
        bundle.putParcelable(PagerFragment.PRODUCTS ,getProducts1())
        launchFragmentInHiltContainer<PagerFragment>(bundle)
    }



    @Test
    fun shouldShowPageIndicator(){
        val bundle =Bundle()
        bundle.putParcelable(PagerFragment.PRODUCTS ,MockitoTest.getproducts())
        launchFragmentInHiltContainer<PagerFragment>(bundle){
            Assert.assertEquals(View.VISIBLE ,this.indicator.visibility) }
    }

    @Test
    fun shouldHidePageIndicator() {

//
//        val products = Mockito.mock(Products::class.java)
//
//        val productDetails =Mockito.mock(ProductsDetails::class.java)
//
//        Mockito.`when`(productDetails.name).thenReturn("Sizes")
//        Mockito.`when`(productDetails.arrayList).thenReturn(getStringList())
//
//
//        Mockito.`when`(products.productId).thenReturn("SM12334")
//        Mockito.`when`(products.productType).thenReturn("Jeans")
//        Mockito.`when`(products.categoryName).thenReturn("Men")
//        Mockito.`when`(products.productName).thenReturn("Shirt")
//        Mockito.`when`(products.numRating).thenReturn("4")
//        Mockito.`when`(products.inStock).thenReturn(5)
//        Mockito.`when`(products.avgRating).thenReturn("1.33")
//        Mockito.`when`(products.productImage).thenReturn(getImageList())
//        Mockito.`when`(products.priceDescription).thenReturn("This is my First Ap")
//        Mockito.`when`(products.productPrice).thenReturn(1200)
//        Mockito.`when`(products.productsDetails).thenReturn(arrayListOf(productDetails))
//

    }

    fun getProducts1() :Products{


        val products = Mockito.mock(Products::class.java)

        val productDetails =Mockito.mock(ProductsDetails::class.java)

        Mockito.`when`(productDetails.name).thenReturn("Sizes")
        Mockito.`when`(productDetails.arrayList).thenReturn(getStringList())


        Mockito.`when`(products.productId).thenReturn("SM12334")
        Mockito.`when`(products.productType).thenReturn("Jeans")
        Mockito.`when`(products.categoryName).thenReturn("Men")
        Mockito.`when`(products.productName).thenReturn("Shirt")
        Mockito.`when`(products.numRating).thenReturn("4")
        Mockito.`when`(products.inStock).thenReturn(5)
        Mockito.`when`(products.avgRating).thenReturn("1.33")
        Mockito.`when`(products.productImage).thenReturn(getImageList())
        Mockito.`when`(products.priceDescription).thenReturn("This is my First Ap")
        Mockito.`when`(products.productPrice).thenReturn(1200)
        Mockito.`when`(products.productsDetails).thenReturn(arrayListOf(productDetails))


        return products
    }




   private  fun   getImageList() :List<String>{
         return listOf("android.resource://image.crystalapps.kecommerce/drawable/jeans",
               "android.resource://image.crystalapps.kecommerce/drawable/jeans",
             "android.resource://image.crystalapps.kecommerce/drawable/jeans") }


      private  fun   getStringList() :ArrayList<Sizes>?{
          var sizes =Sizes("Sizes","android.resource://image.crystalapps.kecommerce/drawable/jeans")
        return arrayListOf<Sizes>(sizes)
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



