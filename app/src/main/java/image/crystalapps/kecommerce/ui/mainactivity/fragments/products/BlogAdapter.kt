package image.crystalapps.kecommerce.ui.mainactivity.fragments.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.databinding.BlogItemDataBinding
import image.crystalapps.kecommerce.model.Products

class BlogAdapter(diffUtil: DiffUtil.ItemCallback<Products>) :BaseAdapter<Products , BlogItemDataBinding>(diffUtil) {

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup, viewType: Int):
            BlogItemDataBinding = DataBindingUtil.inflate(inflater , R.layout.blogitem_layout ,parent ,false)

    override fun bind(binding: BlogItemDataBinding, item: Products) {
        binding.run{
            product =item } }

    override fun onDataChanged(values: Boolean) {

    }


}