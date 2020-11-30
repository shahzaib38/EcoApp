package image.crystalapps.kecommerce.ui.productselection

import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.transition.Transition
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.ProductDataBinding
import image.crystalapps.kecommerce.listeners.FragmentVisibilityListener
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes
import image.crystalapps.kecommerce.ui.base.BaseActivity
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.LogInDialogFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.related.RelatedFragment
import image.crystalapps.kecommerce.ui.productselection.fragments.PagerFragment
import image.crystalapps.kecommerce.utils.OnItemClickListener
import kotlinx.android.synthetic.main.activity_product_selection.*

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

        product = intent.getParcelableExtra<Products>("parcel")


//        ViewCompat.setTransitionName(imagedesign, IMAGE_HEADER);
        loadItem()
        setUpRelatedFragmentListener()
        setUpPagerFragment(product)
    }


    private fun setUpPagerFragment(products: Products){
    val pagerFragment=    PagerFragment.getInstance(products ,1)
        pagerFragment.run {
            supportFragmentManager.beginTransaction().replace(R.id.multiImageContainer ,this).commit() }

    }

   private fun setUpRelatedFragmentListener(){
      val relatedFragment = RelatedFragment.getInstance("men")
       relatedFragment.fragmentVisibilityListener =object :FragmentVisibilityListener{
           override fun changeVisibility(isVisible: Boolean) {
               if(isVisible)View.VISIBLE else View.GONE } }
       supportFragmentManager.beginTransaction().replace(R.id.relatedContainer ,relatedFragment).commit()

    }


   private fun loadIcon(){
     //   mProductSelectionDataBinding?.run {
   //         Glide.with(imagedesign.context).load(product.productImage?.toUri()).into(this.imagedesign) }

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
                   transition.removeListener(this) }

               override fun onTransitionResume(transition: Transition) {}

               override fun onTransitionPause(transition: Transition) {}

               override fun onTransitionCancel(transition: Transition) {
                   transition.removeListener(this) }

               override fun onTransitionStart(transition: Transition) {}
           }
           )
           return true }
       return false }

    override fun clickItem(view: View, item: Sizes) {

    }

    override fun addToCart() {
        if(Firebase.auth.currentUser !=null){
            Toast.makeText(this ,"Added to Cart",Toast.LENGTH_LONG).show()
            mViewModel.addToCart(Cart(1,product)) }
        else{
           LogInDialogFragment.getInstance().showDialog(supportFragmentManager)
        }
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
        uriArray.add(uri.toString())
        uriArray.add(uri.toString())
        uriArray.add(uri.toString())
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
