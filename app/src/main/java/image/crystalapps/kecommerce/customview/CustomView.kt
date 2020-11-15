package image.crystalapps.kecommerce.customview

import android.content.Context
import android.net.Uri
import android.widget.TextView
import androidx.annotation.DimenRes
import androidx.databinding.BindingAdapter
import com.facebook.drawee.backends.pipeline.Fresco
import com.facebook.drawee.view.SimpleDraweeView
import com.facebook.imagepipeline.common.ResizeOptions
import com.facebook.imagepipeline.request.ImageRequestBuilder
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.extensions.sum
import image.crystalapps.kecommerce.model.Cart
import java.math.BigDecimal


@BindingAdapter("customImageUrl")
fun setResizedImageUri(
    simpleDraweeView: SimpleDraweeView,
    src: String?
) {

    val widthRes: Int = R.dimen.default_image_size
    val heightRes: Int = R.dimen.default_image_size

    src?.let {
        val width = simpleDraweeView.context.resources.getDimensionPixelSize(widthRes)
        val height = simpleDraweeView.context.resources.getDimensionPixelSize(heightRes)
        val request = ImageRequestBuilder.newBuilderWithSource(Uri.parse(it))
            .setResizeOptions(ResizeOptions(width, height))
            .build()
        simpleDraweeView.controller = Fresco.newDraweeControllerBuilder()
            .setOldController(simpleDraweeView.controller)
            .setImageRequest(request)
            .build() }


}




//@BindingAdapter("totalPrice")
//fun totalPrice(totalId :TextView,totalPrice : String?){
//
//    val totalText=  totalPrice?.let {
//    "Total Price $totalPrice" }?: "Total Price 0"
//
//    totalId.text =totalText
//}
//
//@BindingAdapter("totalItems")
//fun totalItems(totalItemTextView: TextView ,totalitems :Int?){
//    val totalText=  totalitems?.let { it.sum() }?: "Items: 0"
//    totalItemTextView.text =totalText
//}


@BindingAdapter("totalPrice")
fun totalPrice(totalId : TextView, totalPrice : String?){

    val totalText=  totalPrice?.let {
        "Total Price $totalPrice" }?: "Total Price 0"

    totalId.text =totalText
}

@BindingAdapter("totalItems")
fun totalItems(totalItemTextView: TextView, totalitems :Int?){
    val totalText=  totalitems?.let { it.sum() }?: "Items: 0"
    totalItemTextView.text =totalText
}

