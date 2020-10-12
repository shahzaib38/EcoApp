package image.crystalapps.kecommerce.data

import image.crystalapps.Products
import image.crystalapps.ekommercelibraries.data.BaseDataManager
import image.crystalapps.kecommerce.data.database.prefs.SharedPreferenceEntry
import image.crystalapps.kecommerce.utils.ProductLiveData
import image.crystalapps.kecommerce.utils.QueryLiveData

interface DataManager :BaseDataManager{


    fun saveTokenInformation(sharedPreferenceEntry: SharedPreferenceEntry)
    fun registerInstanceIdManager(newToken :String?)
    fun getAllProducts() :QueryLiveData<Products>
    fun getClothesData(categoryName : String): QueryLiveData<Products>
    fun getCartItem():QueryLiveData<Products>
    suspend fun  addToCart(product: Products)
}