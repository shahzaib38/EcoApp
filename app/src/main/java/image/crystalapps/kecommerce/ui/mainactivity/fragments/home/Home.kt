package image.crystalapps.kecommerce.ui.mainactivity.fragments.home

import android.content.Context
import android.content.Intent
import android.graphics.Rect
import android.net.Uri
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.annotation.DimenRes
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.tasks.Task
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import image.crystala.MainActivity
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.HiltTestActivity
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.HomeFragmentBinding
import image.crystalapps.kecommerce.databinding.replaceOnce
import image.crystalapps.kecommerce.listeners.FragmentVisibilityListener
import image.crystalapps.kecommerce.listeners.OnItemClickListener
import image.crystalapps.kecommerce.model.Categories
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes
import image.crystalapps.kecommerce.pagination.FireStorePagingSource
import image.crystalapps.kecommerce.ui.base.BaseFragment
import image.crystalapps.kecommerce.ui.clothes.ClothesActivity
import image.crystalapps.kecommerce.ui.mainactivity.fragments.popular.PopularFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.products.BlogAdapter
import image.crystalapps.kecommerce.ui.mainactivity.fragments.products.BlogFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.recent.RecentProducts
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.tasks.await
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException


@AndroidEntryPoint
class Home : BaseFragment<HomeViewModel, HomeFragmentBinding>() ,
    OnItemClickListener<Categories> {

    private var mHomeFragmentBinding :HomeFragmentBinding?=null
      private lateinit var mMainActivity: MainActivity

    private val mViewModel by viewModels<HomeViewModel>()

    private  lateinit var navController: NavController


    //Diff Call Back
    private val mClothItemCallBack = object : DiffUtil.ItemCallback<Categories>(){
        override fun areItemsTheSame(oldItem: Categories, newItem: Categories):
                Boolean =false
        override fun areContentsTheSame(oldItem: Categories, newItem: Categories):
                Boolean = oldItem==newItem}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mHomeFragmentBinding= getViewDataBinding()

        if(getBaseActivity() is MainActivity) {

//            val toolbar = mHomeFragmentBinding?.homeToolbar
//            toolbar?.setTitle("Shopping")
//            mMainActivity.setSupportActionBar(toolbar)

            mMainActivity = getBaseActivity() as MainActivity
            mHomeFragmentBinding?.run {
            //    mMainActivity.setSupportActionBar(homeToolbar)
            //    navController = Navigation.findNavController(root)



            }
        }
        else if(getBaseActivity() is HiltTestActivity) {
        } else{
            throw ClassCastException("Home Fragment is not Child Class of BaseActivity")
        }

        mViewModel.setUpCategories()
        initFragments()
        setHasOptionsMenu(true)

        setUpRecyclerView()
    }





    private  fun setUpRecyclerView(){

//Diff Call Back
         val mClothItemCallBack = object : DiffUtil.ItemCallback<Products>(){
            override fun areItemsTheSame(oldItem: Products, newItem: Products):
                    Boolean =false
            override fun areContentsTheSame(oldItem: Products, newItem: Products):
                    Boolean = oldItem==newItem}

        //   mViewModel.allProductsLiveData.observe(viewLifecycleOwner , androidx.lifecycle.Observer { list ->

//
//      val baseQuery=  Firebase.firestore.collection("Fashion List").document("Men")
//            .collection("Products")
        val list1 =ArrayList<Products>()
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
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
////
////
//        val blogAdapter = BlogAdapter(mClothItemCallBack)
////
////        visibilityListener?.changeVisibility(true)
////             if (list.isNotEmpty()) {
//
//
//
////        blogAdapter.submitList(list1)
//
//        requireView().findViewById<RecyclerView>(R.id.recyclerView).run {
//            this.layoutManager =  GridLayoutManager(requireContext(), 2)
//            this.adapter = blogAdapter
//            this.isNestedScrollingEnabled = false
//            this.adapter =blogAdapter
//
//
//        }
//
//
//        lifecycleScope.launch {
//            getFireStoreResult().observe(getBaseActivity() as MainActivity) {
//
//                println("Thread Naem ${Thread.currentThread().name}")
//
//
//                blogAdapter.submitData((getBaseActivity() as MainActivity).lifecycle ,it)
//
//            }
//        }

//
//        mViewModel.getFireStoreResult().collect {
//
//            blogAdapter.submitData(it)
//        }

    }



    private fun recentFragment(){
       childFragmentManager.replaceOnce(R.id.recentContainer ,RecentProducts::class.java.name ,{
           val fragment  = RecentProducts()
           fragment.visibilityListener  =      object: FragmentVisibilityListener{
               override fun changeVisibility(isVisible: Boolean) {

                   recentContainer.visibility =if(isVisible)View.VISIBLE else View.GONE
               } }
           fragment }).commit()
   }
    private fun popularFragment(){
        childFragmentManager.replaceOnce(R.id.popularContainer ,PopularFragment::class.java.name ,{
            val fragment  =   PopularFragment()
            fragment.visibilityListener  =      object: FragmentVisibilityListener{
                override fun changeVisibility(isVisible: Boolean) {
                    popularContainer.visibility =if(isVisible)View.VISIBLE else View.GONE } }
            fragment }).commit()
    }
    private fun blogFragment(){
        childFragmentManager.replaceOnce(R.id.blogContainer ,BlogFragment::class.java.name ,{
            val fragment  =  BlogFragment()
            fragment.visibilityListener  = object: FragmentVisibilityListener{
                override fun changeVisibility(isVisible: Boolean) {
                    blogContainer.visibility =if(isVisible)View.VISIBLE else View.GONE } }
            fragment }).commit()
    }

    private fun initFragments(){
       recentFragment()
       popularFragment()
       blogFragment() }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }





    override fun getViewModel(): HomeViewModel =mViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel}

    override fun getLayoutId(): Int {
    return R.layout.fragment_home }

    override fun clickItem(view: View, item: Categories) {
//     val bundle=   bundleOf("category" to item.name)
//        navController.navigate(R.id.From_Home_To_ClothActivity ,bundle)

            val intent =Intent(mMainActivity , ClothesActivity::class.java)
              intent.putExtra("category" ,item.name)
            startActivity(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbarmenu ,menu)
        super.onCreateOptionsMenu(menu, inflater) }




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
