package image.crystalapps.kecommerce.ui.clothes.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.databinding.SortItemDataBinding
import image.crystalapps.kecommerce.model.Sort
import image.crystalapps.kecommerce.listeners.OnItemClickListener

class SortAdapter(private val itemClickListener: OnItemClickListener<Sort>, diffUtil: DiffUtil.ItemCallback<Sort>) :BaseAdapter<Sort, SortItemDataBinding>(diffUtil) {


    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup, viewType: Int):
            SortItemDataBinding = DataBindingUtil.inflate(inflater , R.layout.sort_item,parent ,false)

    override fun bind(binding: SortItemDataBinding, item: Sort) {
        binding.run { sort=item }
        binding.sortMain.setOnClickListener {
            itemClickListener.clickItem(binding.root,item)
        }
    }

    override fun onDataChanged(values: Boolean) {

    }


}