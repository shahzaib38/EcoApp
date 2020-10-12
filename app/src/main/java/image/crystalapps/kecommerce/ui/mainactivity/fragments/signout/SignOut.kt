package image.crystalapps.kecommerce.ui.mainactivity.fragments.signout

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import image.crystalapps.ekommercelibraries.ui.base.BaseFragment
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.BlankDialogBinding
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.LogInDialogFragment
import image.crystalapps.kecommerce.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class SignOut : BaseFragment<SignOutViewModel , BlankDialogBinding>() {
    @Inject
    lateinit var mViewModelProviderFactory: ViewModelProviderFactory
    private var mSignOutFragmentBinding :BlankDialogBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mSignOutFragmentBinding=     getViewDataBinding()

        showLoginDialog()
    }

   fun showLoginDialog(){
       LogInDialogFragment.getInstance().showDialog(requireActivity().supportFragmentManager)

   }

    override fun getViewModel(): SignOutViewModel {
        return ViewModelProvider(this, mViewModelProviderFactory).get(
            SignOutViewModel::class.java)

    }

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.blank_fragment }


}
