package image.crystalapps.kecommerce.data

import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.data.database.prefs.SharedPreferenceEntry
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.model.Filter
import image.crystalapps.kecommerce.model.UserProfile
import image.crystalapps.kecommerce.utils.ProductLiveData
import image.crystalapps.kecommerce.utils.QueryLiveData

interface DataManager{


    fun saveTokenInformation(sharedPreferenceEntry: SharedPreferenceEntry)
    fun registerInstanceIdManager(newToken :String?)
    fun getAllProducts() :QueryLiveData<Products>
    fun getClothesData(filter : Filter): QueryLiveData<Products>

    fun getCartItem():QueryLiveData<Cart>
     fun  addToCart(product: Cart)
    fun decrement(product: Cart)

    fun getUserProfile(userId :String) : ProductLiveData<UserProfile>
    fun loadRelatedProducts(categoryNaem : String ,productValue :String):  QueryLiveData<Products>


}