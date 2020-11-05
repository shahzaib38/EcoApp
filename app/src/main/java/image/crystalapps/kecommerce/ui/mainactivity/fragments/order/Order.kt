package image.crystalapps.kecommerce.ui.mainactivity.fragments.order

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR

import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.OrderFragmentBinding
import image.crystalapps.kecommerce.ui.base.BaseFragment


@AndroidEntryPoint
class Order : BaseFragment<OrderViewModel, OrderFragmentBinding>() {


    private var mOrderFragmentBinding :OrderFragmentBinding?=null

    private val mViewModel by viewModels<OrderViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mOrderFragmentBinding=  getViewDataBinding()


    }


    override fun getViewModel(): OrderViewModel =mViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_order
    }

}
