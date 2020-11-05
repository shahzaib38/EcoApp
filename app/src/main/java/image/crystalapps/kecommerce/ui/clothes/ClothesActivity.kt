package image.crystalapps.kecommerce.ui.clothes

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.os.bundleOf
import androidx.core.util.Pair
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.navArgs
import androidx.navigation.ui.NavigationUI
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.ClothesDataBinding
import image.crystalapps.kecommerce.model.Filter
import image.crystalapps.kecommerce.model.Sort
import image.crystalapps.kecommerce.ui.base.BaseActivity
import image.crystalapps.kecommerce.ui.clothes.fragments.SortDialogFragment
import image.crystalapps.kecommerce.ui.productselection.ProductSelectionActivity
import image.crystalapps.kecommerce.ui.productselection.dialogfragment.FilterDialogFragment
import image.crystalapps.kecommerce.utils.FilterListener
import image.crystalapps.kecommerce.utils.OnItemClickListener


@AndroidEntryPoint
class ClothesActivity : BaseActivity<ClothesViewModel, ClothesDataBinding>(),
    OnItemClickListener<Products> , FilterListener , CLothesNavigator {

    private val mViewModel by viewModels<ClothesViewModel>()
    override fun getBindingVariable(): Int =BR.viewModel
    override fun getLayoutId(): Int =  R.layout.activity_clothes
    override fun getViewModel(): ClothesViewModel=mViewModel
    private var mClothesDataBinding :ClothesDataBinding?=null


//    private val clothArgs =navArgs<ClothesActivityArgs>()

    private  lateinit var navController :NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mClothesDataBinding =getViewDataBinding()

        mClothesDataBinding?.run {

       //   navController=  Navigation.findNavController(root)

        }

         mViewModel.setNavigator(this)


        val category =intent.getStringExtra("category")
         if(category!=null) {
        mClothesDataBinding?.clothesToolbar.run{
            title=category
             setSupportActionBar(this) }
             Toast.makeText(this, category, Toast.LENGTH_LONG).show()
             mViewModel.filter.value=Filter.default }
       mViewModel.allProductsLiveData.observe(this ,clothesPurchase)

    }


    override fun clickItem(view : View, item: Products) {
        val activityOption =ActivityOptionsCompat.makeSceneTransitionAnimation(this,Pair(view.findViewById(R.id.imageView2),ProductSelectionActivity.IMAGE_HEADER))
        Toast.makeText(this , item.productName ,Toast.LENGTH_LONG).show()
        val intent= Intent(this ,ProductSelectionActivity::class.java)
        intent.putExtra("parcel" ,item)
        ActivityCompat.startActivity(this,intent ,activityOption.toBundle())

    }

    override fun onFilter(filter: Filter) { mViewModel.filter.value=filter }
    override fun showFilterDialog() {FilterDialogFragment.getInstance().showDialog(supportFragmentManager) }
    override fun showSortDialog() { SortDialogFragment.getInstance().showDialog(supportFragmentManager) }
    fun sortProducts(item: Sort) { Toast.makeText(this ,item.value ,Toast.LENGTH_LONG).show() }



    // Products CallBack
    val clothesPurchase=
        Observer<List<Products>> { list ->
            if (list != null && list.isNotEmpty()) {
                val clothesAdapter = ClothesAdapter(this@ClothesActivity, mClothItemCallBack)
                clothesAdapter.submitList(list)
                mClothesDataBinding?.clothesRecyclerview?.run {
                    this.layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    this.adapter = clothesAdapter
                }


            }
        }


     //Diff Call Back
    private val mClothItemCallBack = object : DiffUtil.ItemCallback<Products>(){
        override fun areItemsTheSame(oldItem: Products, newItem: Products):
                Boolean =oldItem.productId == newItem.productId
        override fun areContentsTheSame(oldItem: Products, newItem: Products):
                Boolean = oldItem==newItem}



}




//
//
//        val uri1: Uri = Uri.parse("android.resource://image.crystalapps.kecommerce/drawable/jeans")
//        val varietiesArray=ArrayList<Sizes>()
//        val varietiesArray1=ArrayList<Sizes>()
//
//     val varieties=  Sizes("" ,uri1.toString())
//        val varieties1=  Sizes("S",null)
//        val varieties2=  Sizes("M",null)
//        val varieties3=  Sizes("L",null)
//        val varieties4=  Sizes("XL",null)
//
//
//        varietiesArray.add(varieties)
//        varietiesArray1.add(varieties1)
//        varietiesArray1.add(varieties2)
//        varietiesArray1.add(varieties3)
//        varietiesArray1.add(varieties4)
//
////        varietiesArray.add(varieties1)
////        varietiesArray.add(varieties1)
//
//
//        val productDetails=ArrayList<ProductsDetails>()
//
//        val productsDetailsItem1 =ProductsDetails("Varietes",varietiesArray )
//        val productsDetailsItem2 =ProductsDetails("sizes",varietiesArray1 )
//
//        productDetails.add(productsDetailsItem1)
//        productDetails.add(productsDetailsItem2)
//
//          val uri: Uri = Uri.parse("android.resource://image.crystalapps.kecommerce/drawable/jeans")
//          val products=  Products("Black T Shirt","SM!2443",uri.toString(),"Black T -shirt with design","12200",productDetails)


//          val list =ArrayList<Products>()

//          list.add(products)
//
//    Firebase.firestore.collection("Fashion").document("products")
//            .collection("Men").document().set(products)




