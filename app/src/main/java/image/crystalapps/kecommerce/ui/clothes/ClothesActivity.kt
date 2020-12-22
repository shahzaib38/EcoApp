package image.crystalapps.kecommerce.ui.clothes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.lifecycle.Observer
import androidx.lifecycle.observe
import androidx.navigation.NavController
import androidx.paging.PagedList
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import image.crystala.MainActivity
import image.crystalapps.data.paging.SnapShotQuery
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.FireStoreLoadStateAdapter
import image.crystalapps.kecommerce.databinding.ClothesDataBinding
import image.crystalapps.kecommerce.listeners.FilterListener
import image.crystalapps.kecommerce.listeners.OnItemClickListener
import image.crystalapps.kecommerce.model.*
import image.crystalapps.kecommerce.paging.DocumentSnapShot
import image.crystalapps.kecommerce.ui.base.BaseActivity
import image.crystalapps.kecommerce.ui.clothes.fragments.SortDialogFragment
import image.crystalapps.kecommerce.ui.productselection.ProductSelectionActivity
import image.crystalapps.kecommerce.ui.productselection.dialogfragment.FilterDialogFragment


@AndroidEntryPoint
class ClothesActivity : BaseActivity<ClothesViewModel, ClothesDataBinding>(),
    OnItemClickListener<Products>,
    FilterListener, CLothesNavigator {

    private val mViewModel by viewModels<ClothesViewModel>()
    override fun getBindingVariable(): Int = BR.viewModel
    override fun getLayoutId(): Int = R.layout.activity_clothes
    override fun getViewModel(): ClothesViewModel = mViewModel
    private var mClothesDataBinding: ClothesDataBinding? = null


//    private val clothArgs =navArgs<ClothesActivityArgs>()

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mClothesDataBinding = getViewDataBinding()

        mClothesDataBinding?.run {

            //   navController=  Navigation.findNavController(root)

        }

        mViewModel.setNavigator(this)


        val category = intent.getStringExtra("category")
        if (category != null) {
            mClothesDataBinding?.clothesToolbar.run {
                title = category
                setSupportActionBar(this)
            }


            mViewModel.filter.value = Filter.default
        }

//        mViewModel.allProductsLiveData.observe(this, clothesPurchase)

        // Products CallBack
        //  val clothesPurchase =
        //       Observer<List<Products>> { list ->
        //     if (list != null && list.isNotEmpty()) {

    //    val list =ArrayList<Products>()
  //      list.add(getProducts())

//        list.add(getProducts())
      //  list.add(getProducts())
    //    list.add(getProducts())
        //  val clothes=  Clothes("Men" ,list1)
//    val list =ArrayList<Clothes>()
//    list.add(clothes)



//
//        val mQuery = Firebase.firestore.collection("Fashion List").document("Men")
//            .collection("Products").limit(10)
//
//        val config = PagedList.Config.Builder()
//            .setEnablePlaceholders(false)
//            .setPrefetchDistance(5)
//            .setPageSize(7)
//            .build()
//        val options = FirestorePagingOptions.Builder<Products>()
//            .setLifecycleOwner(this)
//            .setQuery(mQuery, config, Products::class.java)
//            .build()

  val  pageLive=     Pager(config = PagingConfig(pageSize = 1
            , maxSize = 10,enablePlaceholders = false)
            , pagingSourceFactory = {DocumentSnapShot()}

        ).liveData

        val clothesAdapter = ClothesAdapter(this@ClothesActivity,mClothItemCallBack)

        pageLive.observe(this , Observer {

            clothesAdapter.submitData(this.lifecycle, it)

        })



        mClothesDataBinding?.clothesRecyclerview?.run {
            this.setHasFixedSize(true)

            this.adapter =  clothesAdapter.withLoadStateHeaderAndFooter(
                header = FireStoreLoadStateAdapter { clothesAdapter.retry() },
                footer = FireStoreLoadStateAdapter { clothesAdapter.retry() })


        }

    }


    override fun clickItem(view: View, item: Products) {
        val activityOption = ActivityOptionsCompat.makeSceneTransitionAnimation(
            this,
            Pair(view.findViewById(R.id.imageView2), ProductSelectionActivity.IMAGE_HEADER))
        val intent = Intent(this, ProductSelectionActivity::class.java)
        intent.putExtra("parcel", getProducts())
        ActivityCompat.startActivity(this, intent, activityOption.toBundle())

    }




    override fun onFilter(filter: Filter) {
        mViewModel.filter.value = filter
    }

    override fun showFilterDialog() {
        FilterDialogFragment.getInstance().showDialog(supportFragmentManager)
    }

    override fun showSortDialog() {
        SortDialogFragment.getInstance().showDialog(supportFragmentManager)
    }

    fun sortProducts(item: Sort) {
        Toast.makeText(this, item.value, Toast.LENGTH_LONG).show()
    }




    //Diff Call Back
    private val mClothItemCallBack = object : DiffUtil.ItemCallback<Products>() {
        override fun areItemsTheSame(oldItem: Products, newItem: Products):
                Boolean = oldItem.productId == newItem.productId

        override fun areContentsTheSame(oldItem: Products, newItem: Products):
                Boolean = oldItem == newItem
    }


    // Products


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