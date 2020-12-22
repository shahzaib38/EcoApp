package image.crystalapps.kecommerce.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.kecommerce.model.Model

abstract class FireStoreBaseAdapter<M : Model,VDB : ViewDataBinding>(diffUtil: DiffUtil.ItemCallback<M>) :PagingDataAdapter<M,BaseViewHolder<VDB>>(diffUtil)  {


    override fun onBindViewHolder(holder: BaseViewHolder<VDB>, position: Int) {
        bind(holder.mBinding, getItem(position)!!)
        holder.mBinding.executePendingBindings() }

    abstract fun bind(binding: VDB, item: M)

    abstract fun onDataChanged(values: Boolean)

    abstract fun createBinding(inflater: LayoutInflater, parent: ViewGroup,viewType: Int): VDB


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VDB> {
        val inflator = LayoutInflater.from(parent.context)
        val binding =createBinding(inflator,parent,viewType)
        return BaseViewHolder(binding) }

}