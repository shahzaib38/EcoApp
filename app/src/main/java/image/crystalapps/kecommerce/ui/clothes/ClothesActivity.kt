package image.crystalapps.kecommerce.ui.clothes

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import image.crystalapps.Products
import image.crystalapps.ekommercelibraries.ui.base.BaseActivity
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.ClothesDataBinding
import image.crystalapps.kecommerce.model.Varieties
import image.crystalapps.kecommerce.ui.productselection.ProductSelectionActivity
import image.crystalapps.kecommerce.ui.productselection.dialogfragment.FilterDialogFragment
import image.crystalapps.kecommerce.ui.productselection.varieties.VarietiesDialog
import image.crystalapps.kecommerce.utils.OnItemClickListener
import image.crystalapps.kecommerce.viewmodel.ViewModelProviderFactory
import javax.inject.Inject


class ClothesActivity : BaseActivity<ClothesViewModel ,ClothesDataBinding>(),
    OnItemClickListener<Products> {


    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    override fun getBindingVariable(): Int =BR.viewModel
    override fun getLayoutId(): Int =  R.layout.activity_clothes
    override fun getViewModel(): ClothesViewModel{
         return ViewModelProvider(this, viewModelProviderFactory).get(
            ClothesViewModel::class.java) }

    private var mClothesDataBinding :ClothesDataBinding?=null


    val mClothItemCallBack = object : DiffUtil.ItemCallback<Products>(){
        override fun areItemsTheSame(oldItem: Products, newItem: Products):
                Boolean =oldItem.productId == newItem.productId
        override fun areContentsTheSame(oldItem: Products, newItem: Products):
                Boolean = oldItem==newItem}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mClothesDataBinding =getViewDataBinding()

    val category=  intent.getStringExtra("category")

         if(category!=null) {
        mClothesDataBinding?.clothesToolbar.run{
            title=category
             setSupportActionBar(this)
        }
             Toast.makeText(this, category, Toast.LENGTH_LONG).show()
             getViewModel().setClothData(category).observe(this, Observer { list ->
                 if (list != null && list.isNotEmpty()) {
                  val clothesAdapter = ClothesAdapter(this, mClothItemCallBack)
                  clothesAdapter.submitList(list)
                   mClothesDataBinding?.clothesRecyclerview?.run {
                      this.layoutManager =
                         LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                     this.adapter = clothesAdapter
                 } } })
         }
        FilterDialogFragment.getInstance().showDialog(supportFragmentManager)

    }

    override fun clickItem(view : View, item: Products) {

        val activityOption =ActivityOptionsCompat.makeSceneTransitionAnimation(this,Pair(view.findViewById(R.id.imageView2),ProductSelectionActivity.IMAGE_HEADER))
        Toast.makeText(this , item.productName ,Toast.LENGTH_LONG).show()
        val intent= Intent(this ,ProductSelectionActivity::class.java)
        intent.putExtra("parcel" ,item)
        ActivityCompat.startActivity(this,intent ,activityOption.toBundle()) }





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



