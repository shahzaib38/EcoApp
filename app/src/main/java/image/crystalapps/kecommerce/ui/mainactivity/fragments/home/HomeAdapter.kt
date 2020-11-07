package image.crystalapps.kecommerce.ui.mainactivity.fragments.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.OuterRecyclerViewDataBinding
import image.crystalapps.kecommerce.model.Clothes

class HomeAdapter(diffUtil: DiffUtil.ItemCallback<Clothes>) :image.crystalapps.kecommerce.adapter.BaseAdapter<Clothes , OuterRecyclerViewDataBinding>(diffUtil) {

    override fun onDataChanged(values: Boolean) {}

    override fun bind(binding: OuterRecyclerViewDataBinding, item:Clothes) {
        binding.run {clothes=item} }

    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup, viewType: Int): OuterRecyclerViewDataBinding {
        return DataBindingUtil.inflate(inflater ,R.layout.outer_recyclerview,parent ,false)


    } }



