package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.signout

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import image.crystalapps.ekommercelibraries.ui.base.BaseDialogFragment
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.SignOutDialogDataBinding
import image.crystalapps.kecommerce.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class SignOutDialogFragment :BaseDialogFragment<SignOutViewModel , SignOutDialogDataBinding>() {




    @Inject
    lateinit var mViewModelProviderFactory: ViewModelProviderFactory

    private var mSignInDialogDataBinding: SignOutDialogDataBinding?=null

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


    override fun getViewModel(): SignOutViewModel? {
        return ViewModelProvider(this, mViewModelProviderFactory).get(
            SignOutViewModel::class.java) }

    override fun getLayoutId(): Int {
        return R.layout.fragment_sign_out
    }

}