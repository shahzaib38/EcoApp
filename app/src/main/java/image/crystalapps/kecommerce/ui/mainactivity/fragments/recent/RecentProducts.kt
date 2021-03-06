package image.crystalapps.kecommerce.ui.mainactivity.fragments.recent

import android.graphics.PorterDuff
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.RecentProductDataBinding
import image.crystalapps.kecommerce.listeners.FragmentVisibilityListener
import image.crystalapps.kecommerce.model.Clothes
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes
import image.crystalapps.kecommerce.ui.base.BaseFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.profiledialog.ProfileDialog
import image.crystalapps.kecommerce.ui.mainactivity.fragments.home.InnerAdapter

@AndroidEntryPoint
class RecentProducts  :BaseFragment<RecentProductViewModel , RecentProductDataBinding>() ,RecentProductsNavigator{


    private val mViewModel by viewModels<RecentProductViewModel>()
    var visibilityListener : FragmentVisibilityListener?=null

    private  var mRecentProductDataBinding :RecentProductDataBinding?=null

    override fun getBindingVariable(): Int =BR.viewModel

    override fun getLayoutId(): Int = R.layout.recent_layout

    override fun getViewModel(): RecentProductViewModel =mViewModel



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mRecentProductDataBinding=    getViewDataBinding()
        mViewModel.setNavigator(this)



        setUpRecyclerView()


    }

    private fun setUpRecyclerView(){

        val list1 =ArrayList<Products>()
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        val clothes=  Clothes("Men" ,list1)
        val list =ArrayList<Clothes>()
        list.add(clothes)

        visibilityListener?.changeVisibility(list.isNotEmpty())


    //    mViewModel.allProductsLiveData.observe(viewLifecycleOwner , Observer {list1->



        // if (list != null) {
        Toast.makeText(requireContext() ,"Working" , Toast.LENGTH_LONG).show()
        val clothesAdapter = RecentAdapter(mClothItemCallBack)
        clothesAdapter.submitList(list1)
        mRecentProductDataBinding?.recentRecyclerView?.run {
            this.layoutManager = GridLayoutManager(requireContext(), 2)
            this.adapter = clothesAdapter
            this.isNestedScrollingEnabled=false

        }

       // })
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