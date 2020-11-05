package image.crystalapps.kecommerce.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import image.crystalapps.kecommerce.model.Sizes
import image.crystalapps.kecommerce.ui.productselection.ProductItemAdapter
import kotlin.NullPointerException


@BindingAdapter("productItem")
fun setProductList(recycler: RecyclerView ,list : List<Sizes>?){
    if(list!=null) {
        val producttemAdapter = ProductItemAdapter(mProductItemCallBack)
        producttemAdapter.submitList(list)
        recycler.run {
            this.layoutManager =
                LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
            this.adapter = producttemAdapter }
    }else throw NullPointerException("Product List is null")

}

//Cloth CallBack
val mProductItemCallBack = object : DiffUtil.ItemCallback<Sizes>(){
    override fun areItemsTheSame(
        oldSizes: Sizes,
        newSizes: Sizes
    ): Boolean =false
    override fun areContentsTheSame(
        oldSizes: Sizes,
        newSizes: Sizes
    ): Boolean =false


}



