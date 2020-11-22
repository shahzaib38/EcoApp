package image.crystalapps.kecommerce.customview

import android.view.View
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.ui.checkout.CheckOutAdapter
import kotlinx.android.synthetic.main.my_checkout_cart.view.*

//Cloth List
@BindingAdapter("cartList")
fun setClothList(customCheckOutCartView : CustomCheckOutCartView, list :ArrayList<Cart>?){

 //   if (list!=null ) {
        val clothesAdapter = CheckOutAdapter(mClothItemCallBack)
        clothesAdapter.submitList(list)
        customCheckOutCartView.recyclerView.run {
            this.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            this.adapter = clothesAdapter }

//    }else customCheckOutCartView.visibility = View.GONE

    }




private val mClothItemCallBack = object : DiffUtil.ItemCallback<Cart>(){
    override fun areItemsTheSame(oldItem: Cart, newItem: Cart):
            Boolean =false
    override fun areContentsTheSame(oldItem: Cart, newItem: Cart):
            Boolean = oldItem ==newItem }







