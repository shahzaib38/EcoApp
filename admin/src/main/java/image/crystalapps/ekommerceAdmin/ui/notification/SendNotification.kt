package image.crystalapps.ekommerceAdmin.ui.notification

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.FirebaseApp
import image.crystalapps.ekommercelibraries.ui.base.BaseActivity
import image.crystalapps.ekommercelibraries.viewmodel.ViewModelProviderFactory
import image.crystalapps.ekommerceAdmin.BR
import image.crystalapps.ekommerceAdmin.R
import image.crystalapps.ekommerceAdmin.databinding.SendNotificationBinding
import javax.inject.Inject

class SendNotification: BaseActivity<SendNotificationViewModel,SendNotificationBinding >() {


    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val sendNotificationBinding = getViewDataBinding()
        sendNotificationBinding?.let {

            val sendNotificationBean =SendNotificationBean()
            sendNotificationBean.firstName=""
            it.sendNotification = sendNotificationBean
            it.viewModel = getViewModel()
        }
        }


    override fun getLayoutId(): Int {
    return R.layout.send_notification }



        override fun getViewModel(): SendNotificationViewModel {
            return  ViewModelProvider(this, viewModelProviderFactory).get(
                SendNotificationViewModel::class.java); }





}