package image.crystalapps.kecommerce.ui.productselection.fragments

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.ImageSelectItemDataBinding
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes
import image.crystalapps.kecommerce.ui.base.BaseFragment
import image.crystalapps.kecommerce.ui.productselection.ProductViewModel
import kotlinx.android.synthetic.main.pager_layout.*


@AndroidEntryPoint
class PagerFragment :BaseFragment<ProductViewModel , ImageSelectItemDataBinding>() {


    val mViewModel  by viewModels<ProductViewModel>()

    private var product: Products? = null
    private var isThumbnailMode: Boolean = false
    private lateinit var adapter: ImagePagerAdapter

    private  var mSelectItemDataBinding: ImageSelectItemDataBinding?=null

    override fun getBindingVariable(): Int  =BR.viewModel
    override fun getLayoutId(): Int = R.layout.pager_layout
    override fun getViewModel(): ProductViewModel =mViewModel


    companion object{

           @VisibleForTesting
         const val  PRODUCTS ="products"


        fun getInstance(products :Products ,selectedPosition :Int=0): PagerFragment {
            val fragment = PagerFragment()
            val args = Bundle()
            args.putParcelable(PRODUCTS, products)
            fragment.arguments = args
            return fragment

        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mSelectItemDataBinding= getViewDataBinding()

        var selectedPosition = 0
        arguments?.let {
            product = it.getParcelable(PRODUCTS) }?: throw NullPointerException("Argument is null")

        setupAdapter()

        product?.run {

            adapter = ImagePagerAdapter(this, childFragmentManager)
            pager.adapter = adapter
            setData()
            pager.currentItem = selectedPosition
            indicator.setViewPager(pager)

        }?: throw NullPointerException("Image PAger Adapter is null")

    }

    private fun setData(){
        adapter.notifyDataSetChanged()
        val size =product?.productImage?.size?:0
        noImagePlaceholder.visibility =if (size>0)View.GONE else View.VISIBLE
        println(size)
       indicator.visibility =if(size<=0)View.INVISIBLE else View.VISIBLE
    }

    private fun setupAdapter(){
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