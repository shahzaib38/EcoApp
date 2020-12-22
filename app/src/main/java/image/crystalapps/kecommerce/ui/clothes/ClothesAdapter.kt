package image.crystalapps.kecommerce.ui.clothes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.databinding.ClothesItemDataBinding
import image.crystalapps.kecommerce.listeners.OnItemClickListener
//
//class ClothesAdapter(val itemCallBack: OnItemClickListener<Products>, diffUtils :DiffUtil.ItemCallback<Products>) :BaseAdapter<Products, ClothesItemDataBinding>(diffUtils) {
//    override fun createBinding(inflater: LayoutInflater, parent: ViewGroup, viewType: Int):ClothesItemDataBinding {
//        return DataBindingUtil.inflate(inflater , R.layout.clothes_item,parent ,false) }
//
//    override fun bind(binding: ClothesItemDataBinding, item: Products) {
//        binding.run {
//            products =item
//
//            if(item!=null) {
//                ratingBar.rating = item.avgRating!!.toFloat()
//            }
//        }
//        binding.cardView.setOnClickListener{view->
//            itemCallBack.clickItem(view,item)
//        }
//
//    }
//
//    override fun onDataChanged(values: Boolean) {
//
//    }
//
//}
//
//



class ClothesAdapter(val itemCallBack: OnItemClickListener<Products>, diffUtils :DiffUtil.ItemCallback<Products>) :
    PagingDataAdapter<Products, ClothesAdapter.PhotoViewHolder>(diffUtils) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding =
            ClothesItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return PhotoViewHolder(binding)
    }



    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        val currentItem = getItem(position)

        if (currentItem != null) {

            println(currentItem.productName)
            holder.bind(currentItem)
        }
    }

    class PhotoViewHolder(private val binding: ClothesItemDataBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Products) {
            binding.apply {
                            products =item

            }
        }

    }

}






//


//
//
//class ClothesAdapter(val itemCallBack: OnItemClickListener<Products>, firebasePagingOption : FirestorePagingOptions<Products>) :
//    FirestorePagingAdapter<Products, ClothesAdapter.PhotoViewHolder>(firebasePagingOption) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
//        val binding =
//            ClothesItemDataBinding.inflate(LayoutInflater.from(parent.context), parent, false)
//
//        return PhotoViewHolder(binding)
//    }
//
//
//
//    class PhotoViewHolder(private val binding: ClothesItemDataBinding) :
//        RecyclerView.ViewHolder(binding.root) {
//
//        fun bind(item: Products) {
//            binding.apply {
//                            products =item
//
//            }
//        }
//
//    }
//
//    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int, model: Products) {
//
//        if (model != null) {
//
//            holder.bind(model)
//        }
//    }
//
//}
//
//
//
