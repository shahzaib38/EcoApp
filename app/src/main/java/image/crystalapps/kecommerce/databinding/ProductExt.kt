package image.crystalapps.kecommerce.databinding

import androidx.core.content.ContentProviderCompat.requireContext
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import image.crystalapps.kecommerce.R
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
            val divider = DividerItemDecoration(recycler.context, DividerItemDecoration.VERTICAL)
            divider.setDrawable(ContextCompat.getDrawable(recycler.context, R.drawable.divider_line)!!)
            this.addItemDecoration(divider)
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



