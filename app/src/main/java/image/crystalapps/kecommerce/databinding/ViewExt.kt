package image.crystalapps.kecommerce.databinding

import android.net.Uri
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.*
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseUser
import de.hdodenhof.circleimageview.CircleImageView
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.CategoriesListAdapter
import image.crystalapps.kecommerce.data.Event
import image.crystalapps.kecommerce.model.Categories
import image.crystalapps.kecommerce.model.UserProfile
import image.crystalapps.kecommerce.ui.mainactivity.fragments.home.Home
import image.crystalapps.kecommerce.ui.mainactivity.fragments.home.InnerAdapter
import kotlinx.android.synthetic.main.drawerlayout_navigation.view.*


fun View.snackBarSetup(lifecycleOwner: LifecycleOwner, snackBarEvent :LiveData<Event<Int>>, length :Int){
    snackBarEvent.observe(lifecycleOwner,Observer<Event<Int>>{event->
        event.getContentIfNotHandled()?.let {
            showSnackBar( context.getString(it),length) }?:throw NullPointerException("SnackBarSetup is null")
    })
}


fun View.showSnackBar(snackBarText :String ,length :Int){
    Snackbar.make(this ,snackBarText ,length).show() }

@BindingAdapter("updateProfileContent")
fun View.setProfileContent(userProfile : UserProfile?)
{

    Toast.makeText(this.context ,"Testing" ,Toast.LENGTH_LONG).show()

    val image = profile_image
    val  text =profile_text
    if (userProfile!=null){
        image.run {
            Glide.with(context).load(userProfile.userImageUrl).into(this) }
        text.run {
            this.text =userProfile.username }
    }else{
        image.run {
                Glide.with(context).load(R.drawable.default_profile).into(this) }
        text.run {
            this.text = resources.getString(R.string.user_name) }


    }

}


@BindingAdapter("setImageUrl")
fun setImageUrl(circleImageView: CircleImageView ,uri :Uri?){
    val context =circleImageView.context
    if (uri!=null){
        circleImageView.run {
            Glide.with(context).load(uri).into(this)
        }
    }
    else{
        circleImageView.run {
            Glide.with(context).load(R.drawable.default_profile).into(this)
        }
        } }


// Extenstion function of View
fun View.setUpRecyclerView(home:Home,recyclerView: RecyclerView ,list :List<Categories>?){
   val mAdapter = CategoriesListAdapter(home ,diffCallback)
    mAdapter.submitList(list)
    if (list!=null ) {
        val mLinearLayoutManager =
            LinearLayoutManager(recyclerView.context, LinearLayoutManager.HORIZONTAL, false)
        recyclerView.apply {
            layoutManager = mLinearLayoutManager
            itemAnimator = DefaultItemAnimator()
            adapter = mAdapter
        }
    }else throw NullPointerException("Category List is null or Empty")
}


//@BindingAdapter("allProductsList")
//fun setAllProducts(recyclerView: RecyclerView ,list :List<Demo>?){
//    val mAdapter = HomeAdapter(itemCallBack)
//    if (list!=null && list.isNotEmpty()) {
//        mAdapter.submitList(list as MutableList<image.crystalapps.Demo>)
//        val mLinearLayoutManager = LinearLayoutManager(recyclerView.context, LinearLayoutManager.VERTICAL, false)
//        recyclerView.apply {
//            layoutManager = mLinearLayoutManager
//            itemAnimator = DefaultItemAnimator()
//            adapter = mAdapter
//        }
//    }
//
//
//
//}





//CallBacks
val itemCallBack = object :DiffUtil.ItemCallback<Products>(){
    override fun areItemsTheSame(
        oldItem: Products,
        newItem: Products
    ): Boolean =false
    override fun areContentsTheSame(
        oldItem: Products,
        newItem: Products
    ): Boolean =false


}

//Categories CallBacks
private val diffCallback = object : DiffUtil.ItemCallback<Categories>() {
    override fun areItemsTheSame(oldItem: Categories, newItem: Categories): Boolean =
        false
    override fun areContentsTheSame(oldItem: Categories, newItem: Categories): Boolean =
        oldItem.equals(newItem)
}





//Cloth CallBack
val clothItemCallBack = object : DiffUtil.ItemCallback<Products>(){
    override fun areItemsTheSame(
        oldItem: Products,
        newItem: Products
    ): Boolean =false
    override fun areContentsTheSame(
        oldItem: Products,
        newItem: Products
    ): Boolean =false


}

//Cloth List
@BindingAdapter("clothList")
fun setClothList(recyclerView: RecyclerView ,list :List<Products>?){
    if (list!=null ) {
        val innerAdapter = InnerAdapter(clothItemCallBack)
        innerAdapter.submitList(list)
        recyclerView.run {
            this.layoutManager = GridLayoutManager(context, 3)
            this.adapter = innerAdapter
        }
         } else throw NullPointerException("Cloth List is null")

}

@BindingAdapter("productImageUrl")
fun setImageUrl(imageView :ImageView ,productImage: String?){
    if (productImage !=null){
        imageView.run {
            Glide.with(context).load(productImage.toUri()).into(this)

        }
    }else{
        imageView.run {
            Glide.with(context).load(R.drawable.default_profile).into(this) }
    }

}






