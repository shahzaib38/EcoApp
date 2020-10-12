package image.crystalapps.ekommerceAdmin.ui.firebasedemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.toObject
import image.crystalapps.ekommerceAdmin.adapter.FireStoreAdapter
import image.crystalapps.ekommerceAdmin.databinding.ItemRestaurantBinding



interface OnRestaurantSelectedListener{
    fun onSelectedRestaurant(restaurant :DocumentSnapshot)
}


open class RestaurantAdapter constructor(query :Query, private  val listener :OnRestaurantSelectedListener) {


    class ViewHolder(val binding :ItemRestaurantBinding) :RecyclerView.ViewHolder(binding.root){
        fun bind(snapshot: DocumentSnapshot ,listener :OnRestaurantSelectedListener){

            println("Working")
//
           val restaurant =snapshot.toObject<Restaurant>()
            binding.restaurantItemName.text = restaurant!!.name

//          val numRatings: Int = restaurant.numRatings
//            binding.restaurantItemName.text = restaurant.name
//         binding.restaurantItemRating.rating = restaurant.av.toFloat()
//
//      //binding.restaurantItemCity.text = restaurant.city
//      //binding.restaurantItemCategory.text = restaurant.category
//      //binding.restaurantItemNumRatings.text = resources.getString(
//      //R.string.fmt_num_ratings,
//     //numRatings)
//     //binding.restaurantItemPrice.text = RestaurantUtil.getPriceString(restaurant)
//
//       Click listener
      binding.root.setOnClickListener {
      listener.onSelectedRestaurant(snapshot)
      }

        }


//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
//        return ViewHolder(ItemRestaurantBinding.inflate(LayoutInflater.from(parent.context) ,parent ,false))
//    }
//
//    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        holder.bind(getSnapshot(position) , listener)
//        println("Working")
//    }


}}