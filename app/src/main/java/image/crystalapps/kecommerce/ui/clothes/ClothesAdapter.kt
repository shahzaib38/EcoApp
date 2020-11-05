package image.crystalapps.kecommerce.ui.clothes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.databinding.ClothesItemDataBinding
import image.crystalapps.kecommerce.utils.OnItemClickListener

class ClothesAdapter(val itemCallBack:OnItemClickListener<Products>, diffUtils :DiffUtil.ItemCallback<Products>) :BaseAdapter<Products, ClothesItemDataBinding>(diffUtils) {
    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup, viewType: Int):ClothesItemDataBinding {
        return DataBindingUtil.inflate(inflater , R.layout.clothes_item,parent ,false) }

    override fun bind(binding: ClothesItemDataBinding, item: Products) {
        binding.run {
            products =item

            if(item!=null) {
                ratingBar.rating = item.avgRating!!.toFloat()
            }
        }
        binding.cardView.setOnClickListener{view->
            itemCallBack.clickItem(view,item)
        }

    }

    override fun onDataChanged(values: Boolean) {

    }

}



