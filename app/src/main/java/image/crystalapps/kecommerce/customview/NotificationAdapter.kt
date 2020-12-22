package image.crystalapps.kecommerce.customview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.databinding.NotificationItemDataBinding
import image.crystalapps.kecommerce.model.NotificationBean

class NotificationAdapter(val diffUtil: DiffUtil.ItemCallback<NotificationBean>) :BaseAdapter<NotificationBean , NotificationItemDataBinding>(diffUtil) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): NotificationItemDataBinding =     DataBindingUtil.inflate(inflater , R.layout.notificationitem_layout ,parent ,false)

    override fun bind(binding: NotificationItemDataBinding, item: NotificationBean) {

        binding.run {
            notificationItem =item }

    }

    override fun onDataChanged(values: Boolean) {

    }


}