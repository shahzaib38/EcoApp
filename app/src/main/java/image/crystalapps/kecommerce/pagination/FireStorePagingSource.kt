package image.crystalapps.kecommerce.pagination

import androidx.paging.PagingSource
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import image.crystalapps.kecommerce.model.Products
import kotlinx.coroutines.tasks.await

class FireStorePagingSource :PagingSource<QuerySnapshot ,Products>() {


    override suspend fun load(params: LoadParams<QuerySnapshot>): LoadResult<QuerySnapshot, Products> {


       return try {
               val currentPage =
                   params.key ?: Firebase.firestore.collection("Fashion List").document("Men")
                       .collection("Products").limit(10).get().await()
               println("Thread Name Load ${Thread.currentThread().name}")


               val lastDocumentSnapshot = currentPage.documents[currentPage.size() - 1]
               val nextPage = Firebase.firestore.collection("Fashion List").document("Men")
                   .collection("Products").limit(10).startAfter(lastDocumentSnapshot)
                   .get()
                   .await()

               LoadResult.Page(
                   data = currentPage.toObjects(Products::class.java),
                   prevKey = currentPage,
                   nextKey = nextPage
               )

        }catch (e :Exception){
            LoadResult.Error(e)

        }


    }


}