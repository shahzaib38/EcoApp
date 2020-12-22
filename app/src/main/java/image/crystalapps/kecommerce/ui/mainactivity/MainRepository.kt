package image.crystalapps.kecommerce.ui.mainactivity

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.liveData
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.data.database.firebase.FirebaseManager
import image.crystalapps.kecommerce.data.database.local.notification.NotificationDao
import image.crystalapps.kecommerce.data.network.firebase.FireStoreAuth
import image.crystalapps.kecommerce.data.network.firebase.FirebaseCart
import image.crystalapps.kecommerce.model.*
import image.crystalapps.kecommerce.pagination.FireStorePagingSource
import image.crystalapps.kecommerce.ui.base.BaseRepository
import image.crystalapps.kecommerce.utils.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MainRepository @Inject constructor(private val  fireStoreAuth: FireStoreAuth, val firebaseManager: FirebaseManager, val dao : NotificationDao, val dataManager: DataManager,
                                         private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
                                         ) :BaseRepository() ,DataManager by dataManager {


   suspend fun getFireStoreResult() =
       Pager(config = PagingConfig(
           pageSize = 1
           , maxSize = 10, enablePlaceholders = false
       )
           , pagingSourceFactory = { FireStorePagingSource() }

       ).flow


//    fun getFireStoreResult()= Pager(PagingConfig(20)) {
//        FireStorePagingSource()
//    }.flow.cachedIn(viewModelScope)


    fun getData(query: Query):LiveData<Result<MutableList<Products>>>{

        return dataManager.getPaginationDocuments(query) }




    //Single Document Retreive
   override  fun getUserProfile(userId :String) : ProductLiveData<UserProfile> {
        val documentReference=  Firebase.firestore.collection("users").document(userId)
        val userProfile=      ProductLiveData(documentReference , UserProfile::class.java)
        documentReference.addSnapshotListener(userProfile)
        return userProfile }

   override  fun getAllProducts(): QueryLiveData<Products> {
        val collection =    Firebase.firestore.collectionGroup("Products")
        val documentRef=    collection.limit(40)
        val productLiveData = QueryLiveData(documentRef ,
            Products::class.java)
        documentRef.addSnapshotListener(productLiveData)
        return productLiveData }

 override    fun registerInstanceIdManager(newToken: String?) {
        val firebaseAuth=  Firebase.auth
        firebaseManager.registerInstanceIdManager(firebaseAuth,newToken)
    }

   override   fun getCartItem():QueryLiveData<Cart>{
        val documentRef=   Firebase.firestore.collection("users").document("7m5pHZ89AecrwnlLKjuoLlZfpMh1")
            .collection("Cart").limit(2)

        val productLiveData = QueryLiveData(documentRef, Cart::class.java)
        documentRef.addSnapshotListener(productLiveData)
        return productLiveData }

    override  fun addToCart(product: Cart) {
        //      withContext(ioDispatcher){
        FirebaseCart.addToCart(product)
        //    }
    }

   override  fun decrement(product: Cart) {
        //      withContext(ioDispatcher){
        FirebaseCart.decrement(product)
            //    }
    }

  override    fun getNotification():QueryLiveData<NotificationBean>{
        val documentRef=   Firebase.firestore.collection("users").document("7m5pHZ89AecrwnlLKjuoLlZfpMh1")
            .collection("notifications").limit(2)
        val productLiveData = QueryLiveData(documentRef, NotificationBean::class.java)
        documentRef.addSnapshotListener(productLiveData)
        return productLiveData }

  override   fun loadRelatedProducts(categoryNaem: String ,productValue :String) : QueryLiveData<Products> {
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


//    override  fun getAccountDetails(userId: String):
//            AddressLiveData<Account> dataManager.getAccountDetails(userId)


    override fun getAccountDetails(userId: String): AddressLiveData<Account> {
        return dataManager.getAccountDetails(userId) }


}