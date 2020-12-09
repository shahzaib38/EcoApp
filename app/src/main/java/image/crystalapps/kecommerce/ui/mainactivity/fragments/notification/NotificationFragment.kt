package image.crystalapps.kecommerce.ui.mainactivity.fragments.notification


import  android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.customview.NotificationAdapter
import image.crystalapps.kecommerce.databinding.NotificationDataBinding
import image.crystalapps.kecommerce.model.NotificationBean
import image.crystalapps.kecommerce.ui.base.BaseFragment


@AndroidEntryPoint
class NotificationFragment : BaseFragment<NotificationViewModel , NotificationDataBinding>() , NotificationNavigator {

    private val mViewModel by viewModels<NotificationViewModel>()
    private var notificationDataBinding :NotificationDataBinding?=null
    override fun getBindingVariable(): Int =BR.viewModel
    override fun getLayoutId(): Int =R.layout.fragment_notification
    override fun getViewModel(): NotificationViewModel =mViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        notificationDataBinding =  getViewDataBinding()
        getViewModel().setNavigator(this)



        mViewModel.allNotificationLiveData.observe(viewLifecycleOwner , Observer {list->

            val notificationAdapter = NotificationAdapter(mNotificationCallBack)
            notificationAdapter.submitList(list)
            notificationDataBinding?.notificationRecyclerview?.run {
                this.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                this.adapter = notificationAdapter
            }

        })


    }

    private val mNotificationCallBack = object : DiffUtil.ItemCallback<NotificationBean>(){
        override fun areItemsTheSame(oldItem: NotificationBean, newItem: NotificationBean):
                Boolean =false
        override fun areContentsTheSame(oldItem: NotificationBean, newItem: NotificationBean):
                Boolean = oldItem ==newItem }


}
