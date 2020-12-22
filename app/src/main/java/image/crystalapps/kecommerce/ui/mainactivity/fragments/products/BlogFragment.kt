package image.crystalapps.kecommerce.ui.mainactivity.fragments.products

import android.content.ClipData.Item
import android.net.Uri
import android.os.Bundle
import android.provider.Settings
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.paging.PagedList
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.paging.FirestorePagingOptions
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import image.crystala.MainActivity
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.MainProductDataBinding
import image.crystalapps.kecommerce.listeners.FragmentVisibilityListener
import image.crystalapps.kecommerce.model.Clothes
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes
import image.crystalapps.kecommerce.pagination.FireStorePagingSource
import image.crystalapps.kecommerce.ui.base.BaseFragment
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


@AndroidEntryPoint
class BlogFragment :BaseFragment<BlogViewModel , MainProductDataBinding>() {

   private val mViewModel by  viewModels<BlogViewModel>()
    private var mMainProductDataBinding :MainProductDataBinding ?=null

    var visibilityListener :FragmentVisibilityListener?=null
//
//    fun getFireStoreResult() =
//        Pager(config = PagingConfig(pageSize = 1
//            , maxSize = 10,enablePlaceholders = false)
//            , pagingSourceFactory = { FireStorePagingSource() }
//
//        ).liveData
//


    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int = R.layout.mainproduct_layout


    override fun getViewModel(): BlogViewModel  =mViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

          mMainProductDataBinding   = getViewDataBinding()

//        mViewModel.getFireStoreResult()
        lifecycleScope.launch {

            mViewModel.getFireStoreResult()

        }

            setUpRecyclerView()

      //  }
    }



    //Diff Call Back
    private val mClothItemCallBack = object : DiffUtil.ItemCallback<Products>(){
        override fun areItemsTheSame(oldItem: Products, newItem: Products):
                Boolean =oldItem.inStock==newItem.inStock
        override fun areContentsTheSame(oldItem: Products, newItem: Products):
                Boolean = oldItem==newItem}


    private  fun setUpRecyclerView(){
     //   mViewModel.allProductsLiveData.observe(viewLifecycleOwner , androidx.lifecycle.Observer { list ->


      val baseQuery=  Firebase.firestore.collection("Fashion List").document("Men")
            .collection("Products")
        val list1 =ArrayList<Products>()
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
//      val clothes=  Clothes("Women" ,list1)
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

        val blogAdapter = BlogAdapter()
//
        visibilityListener?.changeVisibility(true)
//             if (list.isNotEmpty()) {



        blogAdapter.submitList(list1)


                requireView().findViewById<RecyclerView>(R.id.recyclerView).run {

                    this.layoutManager = GridLayoutManager(requireContext(), 2)
                    this.adapter = blogAdapter
                    this.isNestedScrollingEnabled = false
                }


//
//
//
//
//            lifecycleScope.launch {
//
//                   mViewModel.allProductsLiveData.observe(viewLifecycleOwner , androidx.lifecycle.Observer { list ->
//
//                    println("Thread Name Launch ${Thread.currentThread().name}")
//                    println("Thread Name RecyclerView ${Thread.currentThread().name}")
//
//                    blogAdapter.submitList(list)
//
//                })
//
//            }


//        mViewModel.getFireStoreResult().collect {
//
//            blogAdapter.submitData(it)
//        }

    }






    private fun getProducts() : Products {
        val uri1: Uri = Uri.parse("android.resource://image.crystalapps.kecommerce/drawable/jeans")
        val varietiesArray=ArrayList<Sizes>()
        val varietiesArray1=ArrayList<Sizes>()

        val varieties=  Sizes("" ,uri1.toString())
        val varieties1=  Sizes("S",null)
        val varieties2=  Sizes("M",null)
        val varieties3=  Sizes("L",null)
        val varieties4=  Sizes("XL",null)

        varietiesArray.add(varieties)
        varietiesArray1.add(varieties1)
        varietiesArray1.add(varieties2)
        varietiesArray1.add(varieties3)
        varietiesArray1.add(varieties4)

        val productDetails=ArrayList<ProductsDetails>()
        val productsDetailsItem1 = ProductsDetails("Varietes",varietiesArray )
        val productsDetailsItem2 = ProductsDetails("sizes",varietiesArray1 )

        productDetails.add(productsDetailsItem1)
        productDetails.add(productsDetailsItem2)
        val uri: Uri = Uri.parse("android.resource://image.crystalapps.kecommerce/drawable/jeans")



        val uriArray =ArrayList<String>()
        uriArray.add(uri.toString())
        uriArray.add(uri.toString())
        uriArray.add(uri.toString())


        val products= Products(
            "Jeans",
            "men",
            "Black T Shirt",
            "12",
            4,
            "1.33",
            "SM22446",
            uriArray,
            "Black T -shirt with design",
            12200,
            productDetails)
        return products }

}