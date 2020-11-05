package image.crystalapps.kecommerce.ui.productselection

import android.os.Build
import android.os.Bundle
import androidx.core.view.ViewCompat
import android.transition.Transition
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.core.net.toUri
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.ProductDataBinding
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes
import image.crystalapps.kecommerce.ui.base.BaseActivity
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.LogInDialogFragment
import image.crystalapps.kecommerce.utils.OnItemClickListener

@AndroidEntryPoint
class ProductSelectionActivity : BaseActivity<ProductViewModel, ProductDataBinding>()  ,OnItemClickListener<Sizes>,SelectionNavigator {


    companion object {
        val IMAGE_HEADER = "image:header"
    }


    private var mProductSelectionDataBinding :ProductDataBinding?=null

    override fun getBindingVariable(): Int =BR.viewModel
    override fun getLayoutId(): Int = R.layout.activity_product_selection


    private val mViewModel by viewModels<ProductViewModel>()


    override fun getViewModel(): ProductViewModel = mViewModel
     private lateinit var product : Products
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mProductSelectionDataBinding = getViewDataBinding()

        mViewModel.setNavigator(this)
    //    mProductSelectionDataBinding?.run {
            product = intent.getParcelableExtra<Products>("parcel")

     // val parcel=             intent.getStringExtra("parcel")

  //      if(parcel.isNotEmpty()){
       //     Toast.makeText(this ,parcel ,Toast.LENGTH_LONG).show()
//        }else{
//
//            throw NullPointerException("Parcel is null")
//        }

            //    ViewCompat.setTransitionName(imagedesign, IMAGE_HEADER);
   //     }?:throw ClassCastException("Product Activity Binding is null")

        loadItem()
    }

   private fun loadIcon(){
        mProductSelectionDataBinding?.run {
            Glide.with(imagedesign.context).load(product.productImage?.toUri()).into(this.imagedesign)
        }
    }

   private fun loadItem(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && addTransitionListerner()) {
            loadIcon()
            val list=     product.productsDetails
            if(list!=null && list.isNotEmpty()) {
                val producttemAdapter = ProductInnerAdapter(mProductItemCallBack)
                producttemAdapter.submitList(list)
                mProductSelectionDataBinding?.imageRecyclerView?.run {
                    this.layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    this.adapter = producttemAdapter }
            }
        }

    }
   private val mProductItemCallBack = object : DiffUtil.ItemCallback<ProductsDetails>(){
        override fun areItemsTheSame(
            oldItem: ProductsDetails,
            newItem: ProductsDetails
        ): Boolean =false
        override fun areContentsTheSame(
            oldItem: ProductsDetails,
            newItem:ProductsDetails
        ): Boolean =false


    }

   private fun addTransitionListerner():Boolean{

       val transition =window.sharedElementEnterTransition

       if(transition!=null) {
           transition.addListener(object:Transition.TransitionListener{
               override fun onTransitionEnd(transition: Transition) {

                   transition.removeListener(this)
               }

               override fun onTransitionResume(transition: Transition) {
               }

               override fun onTransitionPause(transition: Transition) {
               }

               override fun onTransitionCancel(transition: Transition) {
                   transition.removeListener(this)
               }

               override fun onTransitionStart(transition: Transition) {
               }


           }

           )

           return true
       }

       return false
   }

    override fun clickItem(view: View, item: Sizes) {

    }

    override fun addToCart() {

        if(Firebase.auth.currentUser !=null){
            Toast.makeText(this ,"Added to Cart",Toast.LENGTH_LONG).show()


            mViewModel.addToCart(Cart(1,product))

        }

        else{
           LogInDialogFragment.getInstance().showDialog(supportFragmentManager)
        }


    }


}
