package image.crystalapps.kecommerce.ui.productselection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.databinding.ProductInnerDataBinding
import image.crystalapps.kecommerce.model.ProductsDetails

class ProductInnerAdapter(diffUtil: DiffUtil.ItemCallback<ProductsDetails>) :BaseAdapter<ProductsDetails, ProductInnerDataBinding>(diffUtil) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): ProductInnerDataBinding = DataBindingUtil.inflate(inflater , R.layout.product_inner,parent ,false)



    override fun bind(binding: ProductInnerDataBinding, item: ProductsDetails) {

        binding.run {
            products=item } }

    override fun onDataChanged(values: Boolean) {

    }


}