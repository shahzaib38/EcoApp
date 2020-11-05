package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.networkconnection

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.InternetDataBinding
import image.crystalapps.kecommerce.ui.base.BaseDialogFragment


@AndroidEntryPoint
class InternetManagerDialogFragment : BaseDialogFragment<InternetViewModel, InternetDataBinding>() , InternetNavigator{


      private  var mInternetDataBinding :InternetDataBinding?=null

    private val mViewModel by viewModels<InternetViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mInternetDataBinding=    getViewDataBinding()
        mViewModel.setNavigator(this)



    }

    companion object{
        private const val TAG :String= "InternetDialogFragment"
        fun getInstance(): InternetManagerDialogFragment {
            return InternetManagerDialogFragment()
        }
    }

    override fun getBindingVariable(): Int {
        return BR.viewModel }

    override fun getViewModel(): InternetViewModel =mViewModel

    override fun getLayoutId(): Int {
        return R.layout.internetconnection
    }

    override fun showDialog(fragment: FragmentManager) {
        super.show(fragment,TAG) }



    override fun dismissDialog() {
        super.dismissDialog(TAG)
    }

}