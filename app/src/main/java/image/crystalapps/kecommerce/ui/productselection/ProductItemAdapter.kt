package image.crystalapps.kecommerce.ui.productselection

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.databinding.ItemNameDataBinding
import image.crystalapps.kecommerce.databinding.ProductItemDataBinding
import image.crystalapps.kecommerce.model.Sizes

class ProductItemAdapter(diffUtil: DiffUtil.ItemCallback<Sizes>) :BaseAdapter<Sizes,ViewDataBinding>(diffUtil)  {
    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup, viewType: Int):
            ViewDataBinding {


    return  when(viewType) {

            0-> {
                 DataBindingUtil.inflate(inflater, R.layout.product_sizes, parent, false)
            }

        1->{

            DataBindingUtil.inflate(inflater, R.layout.item_name, parent, false)

        }
        else->{
            DataBindingUtil.inflate(inflater, R.layout.product_sizes, parent, false)

        }


        }

    }


    override fun bind(binding: ViewDataBinding, item: Sizes) {
        if (binding is ProductItemDataBinding){
            binding.run {
                items=item
            }
        }else if(binding is ItemNameDataBinding){
            binding.run {
                items=item
            }

        }
    }

    override fun getItemViewType(position: Int): Int {
        return if (getItem(position).imageUrl.isNullOrEmpty()) 1 else 0
    }

    override fun onDataChanged(values: Boolean) {

    }



}


