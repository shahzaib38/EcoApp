package image.crystalapps.kecommerce.ui.mainactivity.fragments.cart

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import image.crystala.MainActivity
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.HiltTestActivity
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.CartFragmentBinding
import image.crystalapps.kecommerce.extensions.multiple
import image.crystalapps.kecommerce.model.*
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.ui.base.BaseFragment
import image.crystalapps.kecommerce.ui.checkout.CheckOut
import kotlin.collections.ArrayList

@AndroidEntryPoint
class Cart : BaseFragment<CartViewModel, CartFragmentBinding>() ,
    CartNavigator {




    private var mCartFragmentBinding :CartFragmentBinding?=null

      private val mClothItemCallBack = object : DiffUtil.ItemCallback<Cart>(){
        override fun areItemsTheSame(oldItem: Cart, newItem: Cart):
                Boolean =false
        override fun areContentsTheSame(oldItem: Cart, newItem: Cart):
                Boolean = oldItem ==newItem }

      private val mViewModel by viewModels<CartViewModel>()
      private var mainActivity :MainActivity?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mCartFragmentBinding = getViewDataBinding()
        getViewModel().setNavigator(this)
        if(getBaseActivity() is MainActivity) {
             mainActivity = getBaseActivity() as MainActivity
             }else if(getBaseActivity() is HiltTestActivity ){}


        mViewModel.allCartLiveDataManager.observe(viewLifecycleOwner, allCartObserver)

    }




    override fun getViewModel(): CartViewModel =mViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel }

    override fun getLayoutId(): Int {
        return R.layout.fragment_cart }




    //Cart callBacks
   private val allCartObserver = Observer<List<Cart>> {list->
        if(list!=null ) {
            val clothesAdapter =
                CartAdapter(
                    mViewModel,
                    mClothItemCallBack
                )
            clothesAdapter.submitList(list)
            mViewModel.setTotalPrice(list.multiple().toString())
            mViewModel.setItems(list.size)
            mCartFragmentBinding?.run {
                cartRecyclerview.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                cartRecyclerview.adapter = clothesAdapter
            }
           }


    }

    fun checkout(arrayList :ArrayList<Cart>){
    }

    override fun checkOut() {

        val intent = Intent(requireContext() , CheckOut::class.java)
      val cart =  Cart(2 ,getProducts())
        val arrayList =ArrayList<Cart>()
          arrayList.add(cart)
        arrayList.add(cart)
        val cartCheckOut =   CartCheckOut(arrayList ,"5000")
        intent.putExtra("cartCheckOutBundle", cartCheckOut)
        startActivity(intent)
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