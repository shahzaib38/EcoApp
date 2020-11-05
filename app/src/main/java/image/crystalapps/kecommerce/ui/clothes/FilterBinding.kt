package image.crystalapps.kecommerce.ui.clothes

import android.widget.Button
import androidx.databinding.BindingAdapter
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.ui.productselection.dialogfragment.RatingItem
import kotlinx.android.synthetic.main.activity_content.view.*


@BindingAdapter("buttonSelection")
fun setButtonStyle(button :Button ,ratingItem :RatingItem?){

    if(ratingItem!=null){
        button.text = ratingItem.rating.toString()

        if (ratingItem.isSelected){
            button.setBackgroundColor(button.context.resources.getColor(R.color.colorPrimary ,null))

        }else{
            button.setBackgroundColor(button.context.resources.getColor(R.color.white ,null))


        }


    }

}