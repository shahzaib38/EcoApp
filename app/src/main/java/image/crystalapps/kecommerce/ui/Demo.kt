package image.crystalapps.kecommerce.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.lifecycle.viewModelScope
import androidx.paging.*

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.paging.FirestorePagingOptions

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.pagination.FireStorePagingSource
import image.crystalapps.kecommerce.ui.mainactivity.MainRepository
import image.crystalapps.kecommerce.ui.mainactivity.fragments.products.BlogAdapter
import image.crystalapps.kecommerce.ui.mainactivity.fragments.products.BlogViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class Demo : AppCompatActivity() {


  //  fun getFireStoreResult()= Pager(PagingConfig(20)) {
  //      FireStorePagingSource()
//    }.liveData

    fun getFireStoreResult() =
        Pager(config = PagingConfig(pageSize = 1
            , maxSize = 10,enablePlaceholders = false)
            , pagingSourceFactory = {FireStorePagingSource()}

        ).liveData



    //Diff Call Back
    private val mClothItemCallBack = object : DiffUtil.ItemCallback<Products>(){
        override fun areItemsTheSame(oldItem: Products, newItem: Products):
                Boolean =false
        override fun areContentsTheSame(oldItem: Products, newItem: Products):
                Boolean = oldItem==newItem}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo)




        val baseQuery=  Firebase.firestore.collection("Fashion List").document("Men")
            .collection("Products")
//        val list1 =ArrayList<Products>()
//        list1.add(getProducts())
//        list1.add(getProducts())
//        list1.add(getProducts())
//        list1.add(getProducts())
//        val clothes=  Clothes("Women" ,list1)
//        val list =ArrayList<Clothes>()
//        list.add(clothes)
//
//        val config = PagedList.Config.Builder()
//            .setEnablePlaceholders(false)
//            .setPrefetchDistance(10)
//            .setPageSize(20)
//            .build()
//
//        val options =
//            FirestorePagingOptions.Builder<Products>()
//                .setLifecycleOwner(this)
//                .setQuery(baseQuery, config, Products::class.java)
//                .build()
//


//
//        val blogAdapter = BlogAdapter(mClothItemCallBack)
//
//       // if (list.isNotEmpty()) {
//
//            findViewById<RecyclerView>(R.id.recyclerView).run {
//                this.layoutManager =  GridLayoutManager(this@Demo, 2)
//                this.adapter = blogAdapter
//                this.isNestedScrollingEnabled = false
//
//                this.adapter =blogAdapter
//
//
//            }

   // }

//        lifecycleScope.launch {
//           getFireStoreResult().observe(this@Demo) {
//
//                blogAdapter.submitData( this@Demo.lifecycle,it)
//            }
//        }
    }









}
