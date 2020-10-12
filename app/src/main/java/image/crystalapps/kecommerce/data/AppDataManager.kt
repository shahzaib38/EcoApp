package image.crystalapps.kecommerce.data

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.core.OrderBy
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import image.crystalapps.Products
import image.crystalapps.kecommerce.data.database.LocalDataBaseManager
import image.crystalapps.kecommerce.data.database.firebase.FirebaseManager
import image.crystalapps.kecommerce.data.database.prefs.SharedPreferenceEntry
import image.crystalapps.kecommerce.utils.FirebaseCart
import image.crystalapps.kecommerce.utils.ProductLiveData
import image.crystalapps.kecommerce.utils.QueryLiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject


class AppDataManager @Inject constructor(private  val dataBaseManager: LocalDataBaseManager,
                                         private val firebaseManager: FirebaseManager,
                                         private  val ioDispatcher: CoroutineDispatcher=Dispatchers.IO) : DataManager {



 override   fun saveTokenInformation(sharedPreferenceEntry: SharedPreferenceEntry) {
     dataBaseManager.saveInformation(sharedPreferenceEntry) }

    override fun registerInstanceIdManager(newToken: String?) {
           val firebaseAuth=  Firebase.auth
            firebaseManager.registerInstanceIdManager(firebaseAuth,newToken)
    }

    override fun getAllProducts(): QueryLiveData<Products> {
        val documentRef=   Firebase.firestore.collectionGroup("allproducts")
        val productLiveData = QueryLiveData(documentRef ,Products::class.java)
        documentRef.addSnapshotListener(productLiveData)
        return productLiveData }

    override fun getClothesData(categoryName : String): QueryLiveData<Products>{
         val documentRef=Firebase.firestore.collection("Fashion").document("products")
             .collection(categoryName).orderBy("productPrice")
         val productLiveData = QueryLiveData(documentRef ,Products::class.java)
         documentRef.addSnapshotListener(productLiveData)
        return productLiveData
    }


  override  fun getCartItem():QueryLiveData<Products>{
         val documentRef=   Firebase.firestore.collection("users").document("7m5pHZ89AecrwnlLKjuoLlZfpMh1")
            .collection("Cart").orderBy("productPrice")
        val productLiveData = QueryLiveData(documentRef ,Products::class.java)
        documentRef.addSnapshotListener(productLiveData)
        return productLiveData
  }

    override suspend fun addToCart(product: Products) {
        withContext(ioDispatcher){
            FirebaseCart.addToCart(product)
        }
    }


}