package image.crystalapps.kecommerce.databinding

import android.view.View
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.model.UserProfile
import kotlinx.android.synthetic.main.profile.view.*


@BindingAdapter("Profile")
fun View.setprofile(userProfile: UserProfile?){

      val image= circleImageView
      val username  =username1
      val editUserName =editUserName
      val editEmail =editEmail
      val address =editAddress

    if(userProfile!=null) {
        image.run {
            Glide.with(context).load(userProfile.userImageUrl).into(this) }

        if(userProfile.username!=null){

            username.run {
                this.text=userProfile.username
                editUserName.setText(userProfile.username)
            }
        }else{  }


    }
    else{


        image.run {
            Glide.with(context).load(R.drawable.default_profile).into(this) }


        }

    }


