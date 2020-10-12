package image.crystalapps.kecommerce.ui.mainactivity.fragments.order

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import image.crystalapps.ekommercelibraries.ui.base.BaseFragment
import image.crystalapps.kecommerce.BR

import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.OrderFragmentBinding
import image.crystalapps.kecommerce.viewmodel.ViewModelProviderFactory
import javax.inject.Inject


class Order : BaseFragment<OrderViewModel , OrderFragmentBinding>() {
    @Inject
    lateinit var mViewModelProviderFactory: ViewModelProviderFactory

    private var mOrderFragmentBinding :OrderFragmentBinding?=null


//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//      mOrderFragmentBinding=  getViewDataBinding()
//
//


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mOrderFragmentBinding=  getViewDataBinding()
    }


    override fun getViewModel(): OrderViewModel {
        return ViewModelProvider(this, mViewModelProviderFactory).get(
            OrderViewModel::class.java)    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_order
    }

}
