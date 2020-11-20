package image.crystalapps.kecommerce.ui.checkout

import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.customview.CustomCheckOutCartView
import image.crystalapps.kecommerce.databinding.CheckOutDataBinding
import image.crystalapps.kecommerce.model.*
import image.crystalapps.kecommerce.ui.base.BaseActivity


@AndroidEntryPoint
class CheckOut : BaseActivity<CheckOutViewModel, CheckOutDataBinding>() {


    private val mViewModel by  viewModels<CheckOutViewModel>()
       private var mCheckOutDatabinding :CheckOutDataBinding?=null
    override fun getBindingVariable(): Int =BR.viewModel
    override fun getLayoutId(): Int = R.layout.checkout_layout
    override fun getViewModel(): CheckOutViewModel =mViewModel


    //Diff Call Back
    private val mClothItemCallBack = object : DiffUtil.ItemCallback<Cart>(){
        override fun areItemsTheSame(oldItem: Cart, newItem: Cart):
                Boolean =false
        override fun areContentsTheSame(oldItem: Cart, newItem: Cart):
                Boolean = oldItem==newItem}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          mCheckOutDatabinding = getViewDataBinding()





     //   if(intent==null){
            val cartCheckOut= intent.getParcelableExtra<CartCheckOut>("cartCheckOutBundle")

            mCheckOutDatabinding?.run {

                this.cartCheckOut =cartCheckOut

            }?:throw NullPointerException("Cart is null")




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