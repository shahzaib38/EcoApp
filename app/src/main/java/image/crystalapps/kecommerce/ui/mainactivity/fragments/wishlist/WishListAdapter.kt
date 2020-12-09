package image.crystalapps.kecommerce.ui.mainactivity.fragments.wishlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.databinding.WishListItemDataBinding
import image.crystalapps.kecommerce.model.WishModel

class WishListAdapter(diffUtils :DiffUtil.ItemCallback<WishModel>) : BaseAdapter<WishModel , WishListItemDataBinding>(diffUtils) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): WishListItemDataBinding = DataBindingUtil.inflate(inflater , R.layout.wish_list_item_layout ,  parent ,false)

    override fun bind(binding: WishListItemDataBinding, item: WishModel){

        binding.let {
            it.wishlist=item }

    }

    override fun onDataChanged(values: Boolean) {
    }


}