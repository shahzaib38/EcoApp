package image.crystalapps.kecommerce.ui.mainactivity.fragments.related

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.CategoriesListAdapter
import image.crystalapps.kecommerce.databinding.RelatedDataBinding
import image.crystalapps.kecommerce.listeners.FragmentVisibilityListener
import image.crystalapps.kecommerce.model.Categories
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes
import image.crystalapps.kecommerce.ui.base.BaseFragment
import image.crystalapps.kecommerce.ui.clothes.ClothesAdapter
import image.crystalapps.kecommerce.ui.mainactivity.fragments.home.Home
import image.crystalapps.kecommerce.ui.mainactivity.fragments.home.HomeAdapter
import image.crystalapps.kecommerce.ui.mainactivity.fragments.home.InnerAdapter
import kotlinx.android.synthetic.main.profile_dialog.*
import java.util.Observer

@AndroidEntryPoint
class RelatedFragment :BaseFragment<RelatedViewModel , RelatedDataBinding>() ,RelatedNavigator {

    private val mViewModel by viewModels<RelatedViewModel>()
    override fun getBindingVariable(): Int =BR.viewModel
    override fun getLayoutId(): Int  = R.layout.related_layout
    override fun getViewModel(): RelatedViewModel  =mViewModel

    private var mRelatedDataBinding:RelatedDataBinding?=null

     var fragmentVisibilityListener :FragmentVisibilityListener?=null

    companion object {
        fun getInstance(type: String): RelatedFragment {
            val recentFragment = RelatedFragment()
            val bundle = Bundle()
            bundle.putString("categoryType", type)
            recentFragment.arguments = bundle
            return recentFragment
        } }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRelatedDataBinding=  getViewDataBinding()
        mViewModel.setNavigator(this)

        val arguments = arguments?.run {
            get("categoryType")
        }?: throw NullPointerException("Null Pointer Exception Related Fragment ")

        if(arguments is String){
            mRelatedDataBinding?.run {

                setUpRecyclerView(arguments.toString())
            } ?: throw NullPointerException("Null Pointer Exception Related Framgent")

        }

    }

    private fun setUpRecyclerView(categoryName: String) {
    //    mViewModel.allProductsLiveData.observe(viewLifecycleOwner , androidx.lifecycle.Observer {list->


        // Products CallBack
        //  val clothesPurchase =
        //       Observer<List<Products>> { list ->
        //     if (list != null && list.isNotEmpty()) {

        val list =ArrayList<Products>()
        list.add(getProducts())

        list.add(getProducts())
        list.add(getProducts())
        list.add(getProducts())
        //  val clothes=  Clothes("Men" ,list1)
//    val list =ArrayList<Clothes>()
//    list.add(clothes)




        //       }
        //     }




        fragmentVisibilityListener?.changeVisibility(list.isNotEmpty())
            val relatedAdapter =RelatedAdapter(mClothItemCallBack)
            relatedAdapter.submitList(list)
            mRelatedDataBinding?.relatedRecyclerView?.run {
                this.layoutManager = LinearLayoutManager(requireContext() ,
                    LinearLayoutManager.HORIZONTAL,false)
                this.adapter = relatedAdapter }
      //  }
    //    )
    }


    //Diff Call Back
    private val mClothItemCallBack = object : DiffUtil.ItemCallback<Products>(){
        override fun areItemsTheSame(oldItem: Products, newItem: Products):
                Boolean =false
        override fun areContentsTheSame(oldItem: Products, newItem: Products):
                Boolean = oldItem==newItem}



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