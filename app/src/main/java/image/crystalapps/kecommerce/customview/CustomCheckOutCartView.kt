package image.crystalapps.kecommerce.customview

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.Gravity
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes
import image.crystalapps.kecommerce.ui.checkout.CheckOutAdapter
import kotlinx.android.synthetic.main.my_checkout_cart.view.*

class CustomCheckOutCartView(context : Context, AttributeSet :AttributeSet) :LinearLayoutCompat(context  ,AttributeSet) {


    init {




        View.inflate(context , R.layout.my_checkout_cart ,this)
         orientation = VERTICAL
        recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//        val decoration =
//            SpaceDecoration(leftSpace = resources.getDimensionPixelSize(R.dimen.product_variant_item_divider), skipFirst = true)
//        recyclerView.addItemDecoration(decoration)
    }

    //Diff Call Back
    val mClothItemCallBack = object : DiffUtil.ItemCallback<Cart>(){
        override fun areItemsTheSame(oldItem: Cart, newItem: Cart):
                Boolean =false
        override fun areContentsTheSame(oldItem: Cart, newItem: Cart):
                Boolean = oldItem==newItem}


   fun  setData(arrayList : List<Cart>)
   {

      val adapter= CheckOutAdapter( mClothItemCallBack)

       adapter.submitList(arrayList)
       recyclerView.adapter =adapter



   }



}