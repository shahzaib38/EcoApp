package image.crystalapps.kecommerce.ui.productselection.dialogfragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.databinding.RatingDataBinding
import image.crystalapps.kecommerce.utils.OnItemClickListener

class FilterAdapter (val itemClickLister: OnItemClickListener<RatingItem> ,diffUtil :DiffUtil.ItemCallback<RatingItem>) :BaseAdapter<RatingItem , RatingDataBinding>(diffUtil) {

    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): RatingDataBinding = DataBindingUtil.inflate(inflater , R.layout.rating_item , parent ,false)
    override fun bind(binding: RatingDataBinding, item: RatingItem) {
        binding.run {
            ratingItem=item }

        binding.ratingId.setOnClickListener {
        itemClickLister.clickItem(binding.root ,item)

            if(item.isSelected){
                binding.ratingId.setBackgroundColor(binding.root.context.resources.getColor(R.color.colorPrimary ,null))
                item.isSelected=false
            }else{
                binding.ratingId.setBackgroundColor(binding.root.context.resources.getColor(R.color.white ,null))
                item.isSelected=true }

            notifyDataSetChanged() }
    }

    override fun onDataChanged(values: Boolean) {


    }

}