package image.crystalapps.kecommerce.ui.mainactivity.fragments.signout

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.BlankDialogBinding
import image.crystalapps.kecommerce.ui.base.BaseFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.LogInDialogFragment


@AndroidEntryPoint
class SignOut : BaseFragment<SignOutViewModel, BlankDialogBinding>() {

    private var mSignOutFragmentBinding :BlankDialogBinding?=null


    private val mViewModel by viewModels<SignOutViewModel>()



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mSignOutFragmentBinding=     getViewDataBinding()
        showLoginDialog()
    }

   private fun showLoginDialog(){
       LogInDialogFragment.getInstance().showDialog(requireActivity().supportFragmentManager)

   }

    override fun getViewModel(): SignOutViewModel =mViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.blank_fragment }


}
