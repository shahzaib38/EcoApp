package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.signout

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.SignOutDialogDataBinding
import image.crystalapps.kecommerce.ui.base.BaseDialogFragment

@AndroidEntryPoint
class SignOutDialogFragment : BaseDialogFragment<SignOutViewModel, SignOutDialogDataBinding>() {




    private var mSignInDialogDataBinding: SignOutDialogDataBinding?=null

    private val mViewModel by viewModels<SignOutViewModel>()
    override fun getBindingVariable(): Int {
        return BR.viewModel
    }




    companion object{
        private const val TAG :String= "LoginDialogFragment"

        fun getInstance(): SignOutDialogFragment {
            return SignOutDialogFragment()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mSignInDialogDataBinding = getViewDataBinding()

    }


    override fun getViewModel(): SignOutViewModel=mViewModel

    override fun getLayoutId(): Int {
        return R.layout.fragment_sign_out
    }

}