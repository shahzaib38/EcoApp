package image.crystalapps.kecommerce.ui.mainactivity.fragments.popular

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.PopularDataBinding
import image.crystalapps.kecommerce.listeners.FragmentVisibilityListener
import image.crystalapps.kecommerce.model.Clothes
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes
import image.crystalapps.kecommerce.ui.base.BaseFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.home.HomeAdapter
import image.crystalapps.kecommerce.ui.mainactivity.fragments.home.InnerAdapter


@AndroidEntryPoint
class PopularFragment :BaseFragment<PopularViewModel , PopularDataBinding>() {

   private val mViewModel by viewModels<PopularViewModel>()

   private var mPopularDataBinding: PopularDataBinding?=null

    var visibilityListener : FragmentVisibilityListener?=null

    override fun getBindingVariable(): Int =BR.viewModel

    override fun getLayoutId(): Int  =R.layout.popular_layout

    override fun getViewModel(): PopularViewModel =mViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mPopularDataBinding =   getViewDataBinding()

        setUpRecyclerView()
    }
    //Diff Call Back
    private val mClothItemCallBack = object : DiffUtil.ItemCallback<Products>(){
        override fun areItemsTheSame(oldItem: Products, newItem: Products):
                Boolean =false
        override fun areContentsTheSame(oldItem: Products, newItem: Products):
                Boolean = oldItem==newItem}


   private fun setUpRecyclerView(){


       val list1 =ArrayList<Products>()
       list1.add(getProducts())
       list1.add(getProducts())
       list1.add(getProducts())
       list1.add(getProducts())
       val clothes=  Clothes("Men" ,list1)
       val list =ArrayList<Clothes>()
       list.add(clothes)


       visibilityListener?.changeVisibility(list1.isNotEmpty())

       mViewModel.allProductsLiveData.observe(viewLifecycleOwner , Observer {list1->

       val clothesAdapter = InnerAdapter(mClothItemCallBack)
       clothesAdapter.submitList(list1)
       mPopularDataBinding?.popularRecyclerView?.run {
           this.layoutManager = LinearLayoutManager(requireContext() ,LinearLayoutManager.HORIZONTAL,false)
           this.adapter = clothesAdapter
       }

       })
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
        val products= Products(
            "men",
            "Black T Shirt",
            "12",
            4,
            "1.33",
            "SM22446",
            uri.toString(),
            "Black T -shirt with design",
            12200,
            productDetails)
        return products }


}