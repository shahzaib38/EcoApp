package image.crystalapps.kecommerce.ui.mainactivity.fragments.products

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.firestore.paging.FirestorePagingAdapter
import com.firebase.ui.firestore.paging.FirestorePagingOptions
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.adapter.BaseViewHolder
import image.crystalapps.kecommerce.adapter.FireStoreBaseAdapter
import image.crystalapps.kecommerce.databinding.BlogItemDataBinding
import image.crystalapps.kecommerce.model.Products
//
//class BlogAdapter(option :FirestorePagingOptions<Products>) :FirestorePagingAdapter<Products , BaseViewHolder<BlogItemDataBinding>>(option)
//{
//    override fun onCreateViewHolder(
//        parent: ViewGroup,
//        viewType: Int
//    ): BaseViewHolder<BlogItemDataBinding>{
//        val layoutInflater = LayoutInflater.from(parent.context)
//       val binding = BlogItemDataBinding.inflate(layoutInflater, parent, false)
//        return BaseViewHolder(binding)
//    }
//    override fun onBindViewHolder(
//        holder: BaseViewHolder<BlogItemDataBinding>,
//        position: Int,
//        model: Products
//    ) {
//
//        holder.mBinding.product=model
//
//    }
//
//
//}
//

//
//}

class BlogAdapter : BaseAdapter<Products, BlogItemDataBinding>(Companion) {
    companion object : DiffUtil.ItemCallback<Products>() {
        override fun areItemsTheSame(oldItem: Products, newItem: Products): Boolean {
            return oldItem.inStock == newItem.inStock
        }

        override fun areContentsTheSame(oldItem: Products, newItem: Products): Boolean {
            return oldItem == newItem
        }
    }



    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): BlogItemDataBinding {
        val binding = BlogItemDataBinding.inflate(inflater, parent, false)

        return binding
    }

    override fun bind(binding: BlogItemDataBinding, item: Products) {
        binding.product =item
    }

    override fun onDataChanged(values: Boolean) {


    }

}

class CountryViewHolder(val binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root)

//}