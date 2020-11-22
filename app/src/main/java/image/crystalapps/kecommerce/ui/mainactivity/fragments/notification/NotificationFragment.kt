package image.crystalapps.kecommerce.ui.mainactivity.fragments.notification


import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR

import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.NotificationDataBinding
import image.crystalapps.kecommerce.ui.base.BaseFragment


@AndroidEntryPoint
class NotificationFragment : BaseFragment<NotificationViewModel , NotificationDataBinding>() {

    val mViewModel by viewModels<NotificationViewModel>()


    override fun getBindingVariable(): Int =BR.viewModel

    override fun getLayoutId(): Int =R.layout.fragment_notification


    override fun getViewModel(): NotificationViewModel =mViewModel

}
