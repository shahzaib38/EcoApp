package image.crystalapps.kecommerce.adapter

import android.annotation.SuppressLint
import android.os.AsyncTask
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.MainThread
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.DiffUtil.DiffResult
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import image.crystalapps.kecommerce.utils.Model


abstract class BaseAdapter< M :Model, VDB: ViewDataBinding>(diffUtil: DiffUtil.ItemCallback<M>) : ListAdapter<M,BaseViewHolder<VDB>>(diffUtil) {


  //  open var items: List<M>? = ArrayList()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VDB> {
        val inflator = LayoutInflater.from(parent.context)

        val binding = createBinding(inflator, parent ,viewType)
        return BaseViewHolder(binding)
    }


    abstract fun createBinding(inflater: LayoutInflater, parent: ViewGroup,viewType: Int): VDB

    override fun onBindViewHolder(holder: BaseViewHolder<VDB>, position: Int) {
        bind(holder.mBinding, getItem(position))
        holder.mBinding.executePendingBindings()

    }

    abstract fun bind(binding: VDB, item: M)

    abstract fun onDataChanged(values: Boolean)

}


