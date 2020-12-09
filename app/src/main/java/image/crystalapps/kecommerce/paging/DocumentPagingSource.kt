//package image.crystalapps.kecommerce.paging
//
//import androidx.lifecycle.*
//import androidx.paging.PagingSource
//import com.bumptech.glide.load.HttpException
//import com.google.firebase.firestore.DocumentSnapshot
//import com.google.firebase.firestore.FirebaseFirestore
//import com.google.firebase.firestore.Query
//import com.google.firebase.firestore.QuerySnapshot
//import com.google.firebase.firestore.ktx.firestore
//import com.google.firebase.ktx.Firebase
//import image.crystalapps.kecommerce.data.AppDataManager
//import image.crystalapps.kecommerce.data.DataManager
//import image.crystalapps.kecommerce.model.Cart
//import image.crystalapps.kecommerce.model.Products
//import image.crystalapps.kecommerce.utils.Result
//import kotlinx.coroutines.launch
//import java.io.IOException
//import java.lang.Exception
//
//
//
//
//class DocumentPagingSource(private  val dataManager: DataManager) :  PagingSource<QuerySnapshot, Products>() {
//
//
//    lateinit var customDocumentSnapShot :QuerySnapshot
//    lateinit var next: QuerySnapshot
//
//    override suspend fun load(params: LoadParams<QuerySnapshot>): LoadResult<QuerySnapshot, Products>
//    {
//
//
////        return try {
////
////       val querySnapshot=     Firebase.firestore.collection("Fashion List").document("Men")
////                .collection("Products").limit(10)
////
////            val currentPage =params.key ?:querySnapshot.get().result
////
////           val  lastDocumentSnapShot  =currentPage!!.documents[currentPage.size()-1]
////
////            val nextPage = Firebase.firestore.collection("Fashion List").document("Men")
////                .collection("Products").limit(10).startAfter(lastDocumentSnapShot)
////
////
////      val result=      dataManager.getPaginationDocuments(query = nextPage).distinctUntilChanged().map {
////                filterData(it)
////            }
////
////            LoadResult.Page(result.value!!,null ,currentPage)
////
////        }catch (exception :Exception){
////            LoadResult.Error(exception)
////        }
//
//      return  try {
//            val first = Firebase.firestore.collection("Fashion List").document("Men")
//                .collection("Products").limit(10)
//
//            first.get().addOnSuccessListener { documentSnapshots ->
//                // ...
//
//              customDocumentSnapShot = documentSnapshots
//                // Get the last visible document
//                val lastVisible = documentSnapshots.documents[documentSnapshots.size() - 1]
//
//
//                val next = Firebase.firestore.collection("cities")
//                    .orderBy("population")
//                    .startAfter(lastVisible)
//                    .limit(25).get().result
//
//
//
//                this.next =next!!
//
//                LoadResult.Page(documentSnapshots.toObjects(Products::class.java), null, next)
//
//
//            }
//
//          LoadResult.Page(customDocumentSnapShot.toObjects(Products::class.java) ,null ,nextKey = next)
//
//      }catch (e :Exception){
//
//            LoadResult.Error(e)
//        }
//
//
//    }
//
//
//    fun filterData(data : Result<MutableList<Products>>) : List<Products> {
//   //    val result = MutableList<Products>()
//
//        if (data is Result.Success){
//               return data.data }
//
//        if(data is Result.Error){
//            println("Error is cominng")
//            return emptyList<Products>() }
//
//        return emptyList()
//         }
//
////    private fun createList(documents: List<DocumentSnapshot>): List<Products> {
////        val list =ArrayList<Products>()
////        println("Create List")
////        for (document in documents){
////            val model=    document.toObject(Products::class.java)
////            if (model!=null){
////                list.add(model) }
////
////        }
////        return list
////    }
//
//}