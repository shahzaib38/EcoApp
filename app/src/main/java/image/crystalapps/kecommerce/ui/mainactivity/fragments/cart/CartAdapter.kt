package image.crystalapps.kecommerce.ui.mainactivity.fragments.cart

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.Products
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.databinding.CartItemDataBinding

class CartAdapter(diffUtil: DiffUtil.ItemCallback<Products>) :BaseAdapter<Products ,CartItemDataBinding>(diffUtil)
{
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): CartItemDataBinding=
        DataBindingUtil.inflate(inflater , R.layout.cart_item,parent ,false)

    override fun bind(binding: CartItemDataBinding, item: Products) {

        binding.run {
            product =item }



    }

    override fun onDataChanged(values: Boolean) {
    }
}