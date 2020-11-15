package image.crystalapps.kecommerce.ui.mainactivity.fragments.related

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.databinding.RelatedItemDataBinding
import image.crystalapps.kecommerce.model.Products

class RelatedAdapter(difftils :DiffUtil.ItemCallback<Products>) :BaseAdapter<Products , RelatedItemDataBinding>(difftils) {

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int ):RelatedItemDataBinding= DataBindingUtil.inflate(inflater , R.layout.relateditem_layout,parent ,false)


    override fun bind(binding: RelatedItemDataBinding, item: Products) {
        binding.run { this.products =item } }

    override fun onDataChanged(values: Boolean) {


    }


}