package image.crystalapps.kecommerce.ui.mainactivity.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.Products
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.databinding.HomeItemDataBinding

class InnerAdapter(diffUtil: DiffUtil.ItemCallback<Products>): BaseAdapter<Products,HomeItemDataBinding>(diffUtil){
    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup, viewType: Int):
            HomeItemDataBinding =DataBindingUtil.inflate(inflater, R.layout.home_items,parent,false)

    override fun bind(binding: HomeItemDataBinding, item: Products) {
        binding.run {
            demo=item } }

    override fun onDataChanged(values: Boolean) {

    }


}