package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.networkconnection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import image.crystalapps.ekommercelibraries.ui.base.BaseDialogFragment
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.InternetDataBinding
import image.crystalapps.kecommerce.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class InternetManagerDialogFragment :BaseDialogFragment<InternetViewModel , InternetDataBinding>() , InternetNavigator{

    @Inject
    lateinit var mViewModelProviderFactory: ViewModelProviderFactory

      private  var mInternetDataBinding :InternetDataBinding?=null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mInternetDataBinding=    getViewDataBinding()
        getViewModel().setNavigator(this)



    }

    companion object{
        private const val TAG :String= "InternetDialogFragment"
        fun getInstance(): InternetManagerDialogFragment {
            return InternetManagerDialogFragment()
        }
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel }

    override fun getViewModel(): InternetViewModel {
        return ViewModelProvider(this, mViewModelProviderFactory).get(
            InternetViewModel::class.java)
    }

    override fun getLayoutId(): Int {
        return R.layout.internetconnection
    }

    override fun showDialog(fragment: FragmentManager) {
        super.show(fragment,TAG) }



    override fun dismissDialog() {
        super.dismissDialog(TAG)
    }

}