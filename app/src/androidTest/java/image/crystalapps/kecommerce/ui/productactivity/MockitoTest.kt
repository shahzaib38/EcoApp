package image.crystalapps.kecommerce.ui.productactivity


import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes

object MockitoTest {


      fun   getImageList() :List<String>{
        return listOf("android.resource://image.crystalapps.kecommerce/drawable/jeans",
            "android.resource://image.crystalapps.kecommerce/drawable/jeans",
            "android.resource://image.crystalapps.kecommerce/drawable/jeans") }


      fun   getStringList() :ArrayList<Sizes>?{
        var sizes = Sizes("Sizes","android.resource://image.crystalapps.kecommerce/drawable/jeans")


        return arrayListOf<Sizes>(sizes)
    }


    fun getproducts () :Products = mock{

        this.on{this.productName} doReturn "Blue Shirt"
        this.on { this.categoryName } doReturn "Men"
        this.on { this.productId } doReturn "SM1235"
         this.on { this.productType } doReturn "Jeans"
            this.on { this.numRating } doReturn "4"
           this.on { this.inStock } doReturn 6
        this.on { this.avgRating } doReturn "1.33"
        this.on {this.productImage  } doReturn getImageList()
     this.on { this.priceDescription } doReturn "This is my First App"
        this.on { this.productPrice } doReturn 1233
     this.on { productsDetails }.thenReturn(arrayListOf(getProductDetails()))

    }


    fun getProductDetails() : ProductsDetails = mock {
        this.on { this.name } doReturn "Sizes"
         this.on { this.arrayList } doReturn  getStringList()
    }






}