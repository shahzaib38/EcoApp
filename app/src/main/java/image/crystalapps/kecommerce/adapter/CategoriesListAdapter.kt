package image.crystalapps.kecommerce.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.CategoriesListDataBinding
import image.crystalapps.kecommerce.model.Categories
import image.crystalapps.kecommerce.utils.OnItemClickListener

class CategoriesListAdapter(val itemClickListener: OnItemClickListener<Categories> ,diffUtil: DiffUtil.ItemCallback<Categories>) :image.crystalapps.kecommerce.adapter.BaseAdapter<Categories ,CategoriesListDataBinding>(diffUtil){


    override fun bind(binding: CategoriesListDataBinding, item: Categories) {
        binding.apply {
        categories= item }

        binding.categoriesImageView.setOnClickListener {
            itemClickListener.clickItem(binding.root, item)
        }
    }

    override fun onDataChanged(values: Boolean) {
    }

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): CategoriesListDataBinding {
       return DataBindingUtil.inflate(inflater, R.layout.categories_list_view, parent, false)
    }

}