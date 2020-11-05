package image.crystalapps.kecommerce.ui.mainactivity.fragments.products

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
import image.crystalapps.kecommerce.databinding.MainProductDataBinding
import image.crystalapps.kecommerce.listeners.FragmentVisibilityListener
import image.crystalapps.kecommerce.model.Clothes
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes
import image.crystalapps.kecommerce.ui.base.BaseFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.home.HomeAdapter

@AndroidEntryPoint
class MainProducts :BaseFragment<MainProductViewModel , MainProductDataBinding>() {

   private val mViewModel by  viewModels<MainProductViewModel>()
    private var mMainProductDataBinding :MainProductDataBinding ?=null

    var visibilityListener :FragmentVisibilityListener?=null



    override fun getBindingVariable(): Int = BR.viewModel

    override fun getLayoutId(): Int =R.layout.mainproduct_layout


    override fun getViewModel(): MainProductViewModel  =mViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

          mMainProductDataBinding   = getViewDataBinding()

        setUpRecyclerView()


    }



    //Diff Call Back
    private val mClothItemCallBack = object : DiffUtil.ItemCallback<Clothes>(){
        override fun areItemsTheSame(oldItem: Clothes, newItem: Clothes):
                Boolean =false
        override fun areContentsTheSame(oldItem: Clothes, newItem: Clothes):
                Boolean = oldItem==newItem}


    private fun setUpRecyclerView(){
       // mViewModel.allProductsLiveData.observe(viewLifecycleOwner , Observer {list->

        val list1 =ArrayList<Products>()
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
        list1.add(getProducts())
      val clothes=  Clothes("Men" ,list1)
        val list =ArrayList<Clothes>()
        list.add(clothes)

            visibilityListener?.changeVisibility(list.isNotEmpty())

           // if (list != null) {
                Toast.makeText(requireContext() ,"Working" ,Toast.LENGTH_LONG).show()
                val clothesAdapter = HomeAdapter(mClothItemCallBack)
                clothesAdapter.submitList(list)
                mMainProductDataBinding?.recyclerView?.run {
                    this.layoutManager = GridLayoutManager(requireContext(), 2)
                    this.adapter = clothesAdapter
                }?: throw RuntimeException("Runtime Exception ")

            //}else{

              //  throw NullPointerException("Runtime Exception ")

            //}
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