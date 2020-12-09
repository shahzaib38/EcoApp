package image.crystalapps.kecommerce.data

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import image.crystalapps.kecommerce.data.database.LocalDataBaseManager
import image.crystalapps.kecommerce.data.database.firebase.FirebaseManager
import image.crystalapps.kecommerce.data.database.prefs.SharedPreferenceEntry
import image.crystalapps.kecommerce.model.*
import image.crystalapps.kecommerce.utils.AddressLiveData
import image.crystalapps.kecommerce.utils.FirebaseCart
import image.crystalapps.kecommerce.utils.ProductLiveData
import image.crystalapps.kecommerce.utils.QueryLiveData
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
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


        val collection =    Firebase.firestore.collectionGroup("Products")
//
//        collection.whereEqualTo("categoryName","men")
//          collection.whereEqualTo("categoryName" ,"women")

    val documentRef=    collection.limit(20)
        val productLiveData = QueryLiveData(documentRef ,
            Products::class.java)
        documentRef.addSnapshotListener(productLiveData)
        return productLiveData }

    override fun getClothesData(categoryName : image.crystalapps.kecommerce.model.Filter): QueryLiveData<Products>{
//         val documentRef=Firebase.firestore.collection("Fashion").document("products")
//             .collection(categoryName).orderBy("productPrice")

        val productLiveData = QueryLiveData(toQuery(categoryName) ,
            Products::class.java)
        return productLiveData
    }


    //Single Document Retreive
   override fun getUserProfile(userId :String) :ProductLiveData<UserProfile>{
        val documentReference=  Firebase.firestore.collection("users").document(userId)
        val userProfile=      ProductLiveData(documentReference ,UserProfile::class.java)
        documentReference.addSnapshotListener(userProfile)
        return userProfile }

    override fun loadRelatedProducts(categoryNaem: String ,productValue :String) : QueryLiveData<Products> {
        var query: Query=Firebase.firestore.collection("Fashion List").document(categoryNaem)
            .collection("Products").whereEqualTo("productType",productValue)

        val productLiveData = QueryLiveData(query,Products::class.java)
        query.addSnapshotListener(productLiveData)
        return productLiveData
    }

    override fun getPaginationDocuments(query :Query) : QueryLiveData<Products> {
        val productLiveData = QueryLiveData(query,Products::class.java)
        query.addSnapshotListener(productLiveData)
        return productLiveData
    }

    private fun toQuery(filters: Filter): Query{ // Construct query basic query
        var query: Query=Firebase.firestore.collection("Fashion List").document("Men")
            .collection("Products")

        if (filters == null) {
            query.orderBy("avgRating", Query.Direction.ASCENDING)
        } else { // Category (equality filter)
//            if (filters.hasCategory()) {
//                query = query.whereEqualTo(Restaurant.FIELD_CATEGORY, filters.getCategory())
//            }
            // City (equality filter)
//            if (filters.hasCity()) {
//                query = query.whereEqualTo(Restaurant.FIELD_CITY, filters.getCity())
//            }
//            // Price (equality filter)
//
//            if (true) {
//                query = query.whereLessThanOrEqualTo("productPrice" , filters.price)
//            }
            // Sort by (orderBy with direction)
       //     if (filters.hasSortBy()) {

                if(filters!=null) {
                    query = query.orderBy(filters.sortBy?:"productPrice", filters.sortDirection?:Query.Direction.ASCENDING)
                    }

         //   }
        }
        /* query could be limited like: query.limit(5) */return query
    }




//    override fun getClothesDataDesc(filter : Filter): QueryLiveData<Products>{
//        val documentRef=Firebase.firestore.collection("Fashion").document("products")
//            .collection("Men").orderBy("productPrice")
//        val productLiveData = QueryLiveData(documentRef ,Products::class.java)
//
//        documentRef.addSnapshotListener(productLiveData)
//        return productLiveData
//    }

  override  fun getCartItem():QueryLiveData<Cart>{
        val documentRef=   Firebase.firestore.collection("users").document("7m5pHZ89AecrwnlLKjuoLlZfpMh1")
            .collection("Cart").limit(2)

        val productLiveData = QueryLiveData(documentRef,Cart::class.java)
        documentRef.addSnapshotListener(productLiveData)
        return productLiveData }

    override  fun addToCart(product: Cart) {
        //      withContext(ioDispatcher){
        FirebaseCart.addToCart(product)
        //    }
    }

    override fun decrement(product: Cart) {
        //      withContext(ioDispatcher){
        FirebaseCart.decrement(product)
        //    }
    }


    override  fun getNotification():QueryLiveData<NotificationBean>{
        val documentRef=   Firebase.firestore.collection("users").document("7m5pHZ89AecrwnlLKjuoLlZfpMh1")
            .collection("notifications").limit(2)
        val productLiveData = QueryLiveData(documentRef,NotificationBean::class.java)
        documentRef.addSnapshotListener(productLiveData)
        return productLiveData }

 override fun getAddress():AddressLiveData<Address>{
        val documentRef=   Firebase.firestore.collection("users").document("7m5pHZ89AecrwnlLKjuoLlZfpMh1")
            .collection("address").document("usersAddress")
        val userProfile=      AddressLiveData(documentRef ,Address::class.java)
        documentRef.addSnapshotListener(userProfile)
        return userProfile }
}