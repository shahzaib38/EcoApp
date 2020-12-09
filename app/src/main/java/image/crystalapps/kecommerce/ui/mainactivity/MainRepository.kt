package image.crystalapps.kecommerce.ui.mainactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.data.database.firebase.FirebaseManager
import image.crystalapps.kecommerce.data.database.local.notification.NotificationDao
//import image.crystalapps.kecommerce.data.database.local.wishlist.WishListDao
import image.crystalapps.kecommerce.model.*
import image.crystalapps.kecommerce.ui.base.BaseRepository
import image.crystalapps.kecommerce.utils.FirebaseCart
import image.crystalapps.kecommerce.utils.ProductLiveData
import image.crystalapps.kecommerce.utils.QueryLiveData
import image.crystalapps.kecommerce.utils.Result
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(val firebaseManager: FirebaseManager ,val dao : NotificationDao  , val dataManager: DataManager) :BaseRepository() {

    //Single Document Retreive
     fun getUserProfile(userId :String) : ProductLiveData<UserProfile> {
        val documentReference=  Firebase.firestore.collection("users").document(userId)
        val userProfile=      ProductLiveData(documentReference , UserProfile::class.java)
        documentReference.addSnapshotListener(userProfile)
        return userProfile }

     fun getAllProducts(): QueryLiveData<Products> {
        val collection =    Firebase.firestore.collectionGroup("Products")
        val documentRef=    collection.limit(40)
        val productLiveData = QueryLiveData(documentRef ,
            Products::class.java)
        documentRef.addSnapshotListener(productLiveData)
        return productLiveData }

     fun registerInstanceIdManager(newToken: String?) {
        val firebaseAuth=  Firebase.auth
        firebaseManager.registerInstanceIdManager(firebaseAuth,newToken)
    }

      fun getCartItem():QueryLiveData<Cart>{
        val documentRef=   Firebase.firestore.collection("users").document("7m5pHZ89AecrwnlLKjuoLlZfpMh1")
            .collection("Cart").limit(2)

        val productLiveData = QueryLiveData(documentRef, Cart::class.java)
        documentRef.addSnapshotListener(productLiveData)
        return productLiveData }

      fun addToCart(product: Cart) {
        //      withContext(ioDispatcher){
        FirebaseCart.addToCart(product)
        //    }
    }

     fun decrement(product: Cart) {
        //      withContext(ioDispatcher){
        FirebaseCart.decrement(product)
        //    }
    }

      fun getNotification():QueryLiveData<NotificationBean>{
        val documentRef=   Firebase.firestore.collection("users").document("7m5pHZ89AecrwnlLKjuoLlZfpMh1")
            .collection("notifications").limit(2)
        val productLiveData = QueryLiveData(documentRef, NotificationBean::class.java)
        documentRef.addSnapshotListener(productLiveData)
        return productLiveData }

     fun loadRelatedProducts(categoryNaem: String ,productValue :String) : QueryLiveData<Products> {
        var query: Query =Firebase.firestore.collection("Fashion List").document(categoryNaem)
            .collection("Products").whereEqualTo("productType",productValue)

        val productLiveData = QueryLiveData(query,Products::class.java)
        query.addSnapshotListener(productLiveData)
        return productLiveData
    }


    fun observeNotifications() : LiveData<Result<List<NotificationBean>>>{
       return  dao.getAllNotificatios().map {
            Result.Success(it) } }

    fun insert(notificationBean: NotificationBean){
        dao.insert(notificationBean) }


//
//    fun insertWish(wishModel: WishModel){
//        wishDao.insert(wishModel)
//    }
//
//    fun getWishList(): LiveData<Result<List<WishModel>>>{
//
//        return wishDao.getAllWishList().map { Result.Success(it) }
//
//    }

}