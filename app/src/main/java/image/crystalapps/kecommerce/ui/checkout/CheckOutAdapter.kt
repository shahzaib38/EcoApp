package image.crystalapps.kecommerce.ui.checkout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.BaseAdapter
import image.crystalapps.kecommerce.databinding.CheckOutItemDataBinding
import image.crystalapps.kecommerce.model.Cart

class CheckOutAdapter(val checkOutViewModel: CheckOutViewModel ,diffUtil: DiffUtil.ItemCallback<Cart>) :BaseAdapter<Cart ,CheckOutItemDataBinding>(diffUtil) {
    override fun createBinding(
        inflater: LayoutInflater,
        parent: ViewGroup,
        viewType: Int
    ): CheckOutItemDataBinding =
        DataBindingUtil.inflate(inflater , R.layout.checkout_item,parent ,false)

    override fun bind(binding: CheckOutItemDataBinding, item: Cart) {

        binding.run {
            cart =item
           viewModel =checkOutViewModel }
    }

    override fun onDataChanged(values: Boolean) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}