package image.crystalapps.kecommerce.customview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.model.NotificationBean
import image.crystalapps.kecommerce.ui.checkout.CheckOutAdapter
import kotlinx.android.synthetic.main.my_checkout_cart.view.*

//Cloth List
@BindingAdapter("cartList")
fun setClothList(customCheckOutCartView : CustomCheckOutCartView, list :ArrayList<Cart>?){

        val clothesAdapter = CheckOutAdapter(mClothItemCallBack)
        clothesAdapter.submitList(list)
        customCheckOutCartView.recyclerView.run {
            this.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            this.adapter = clothesAdapter }

    }


//
////Cloth List
//@BindingAdapter("notificationList")
//fun setNotificationList(recyclerView : RecyclerView, list :List<NotificationBean>?){
//    //if(list!=null) {
//        val notificationAdapter = NotificationAdapter(mNotificationCallBack)
//        notificationAdapter.submitList(list)
//        recyclerView.run {
//            this.layoutManager =
//                LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//            this.adapter = notificationAdapter
//        }
//   // }
//
//}



private val mClothItemCallBack = object : DiffUtil.ItemCallback<Cart>(){
    override fun areItemsTheSame(oldItem: Cart, newItem: Cart):
            Boolean =false
    override fun areContentsTheSame(oldItem: Cart, newItem: Cart):
            Boolean = oldItem ==newItem }





private val mNotificationCallBack = object : DiffUtil.ItemCallback<NotificationBean>(){
    override fun areItemsTheSame(oldItem: NotificationBean, newItem: NotificationBean):
            Boolean =false
    override fun areContentsTheSame(oldItem: NotificationBean, newItem: NotificationBean):
            Boolean = oldItem ==newItem }


