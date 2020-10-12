package image.crystalapps.ekommerceAdmin.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.toObject
import image.crystalapps.ekommerceAdmin.R
import image.crystalapps.ekommerceAdmin.databinding.ItemRestaurantBinding
import image.crystalapps.ekommerceAdmin.ui.firebasedemo.Restaurant
import image.crystalapps.ekommercelibraries.adapter.BaseViewHolder


interface OnMenFashionSelectedListener{
    fun onSelectedRestaurant(menFashionItem : DocumentSnapshot)
}


open class MenFashionAdapter constructor(query : Query, private  val listener :OnMenFashionSelectedListener) {


    class ViewHolder(binding: ItemRestaurantBinding) : BaseViewHolder<ItemRestaurantBinding>(binding){


        fun bind(snapshot: DocumentSnapshot, listener :OnMenFashionSelectedListener){
            println("Working")
          //  val restaurant =snapshot.toObject<Restaurant>()
          //  binding.restaurantItemName.text = restaurant!!.name

            binding.root.setOnClickListener {
                listener.onSelectedRestaurant(snapshot)
            }

        }


    }


//
//
//    override fun createBinding(layoutInflator: LayoutInflater, parent: ViewGroup): ItemRestaurantBinding {
//      return  DataBindingUtil.inflate(layoutInflator ,R.layout.item_restaurant ,parent ,false) }
//
//    override fun bind(binding: ItemRestaurantBinding, item: Restaurant?) {
//        binding.restaurant=item
//
//    }
//
//    override fun bind(binding: ItemRestaurantBinding, item: DocumentSnapshot?) {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//

}