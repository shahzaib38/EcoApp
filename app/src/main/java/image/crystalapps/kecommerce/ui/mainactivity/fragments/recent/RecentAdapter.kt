package image.crystalapps.kecommerce.ui.mainactivity.fragments.recent

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.databinding.RecentItemDataBinding
import image.crystalapps.kecommerce.model.Products

class RecentAdapter(diffUtil :DiffUtil.ItemCallback<Products>)  :BaseAdapter<Products , RecentItemDataBinding>(diffUtil){


    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup, viewType: Int):
            RecentItemDataBinding =   DataBindingUtil.inflate(inflater , R.layout.recentitem_layout,parent ,false)

    override fun bind(binding: RecentItemDataBinding, item: Products) {
        binding.run {
            this.productsItem =item
        }
    }

    override fun onDataChanged(values: Boolean) {

    }


}