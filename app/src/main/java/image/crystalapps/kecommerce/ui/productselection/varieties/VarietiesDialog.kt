package image.crystalapps.kecommerce.ui.productselection.varieties

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import image.crystalapps.ekommercelibraries.ui.base.BaseDialogFragment
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.VarietiesDataBinding
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.LogInDialogFragment
import image.crystalapps.kecommerce.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class VarietiesDialog :BaseDialogFragment<VarietiesViewModel, VarietiesDataBinding>() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    override fun getBindingVariable(): Int= BR.viewModel
    override fun getViewModel(): VarietiesViewModel?=ViewModelProvider(this, viewModelProviderFactory).get(VarietiesViewModel::class.java)
    override fun getLayoutId(): Int= R.layout.varieties_layout

    private  var mVarietiesDataBinding :VarietiesDataBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
          mVarietiesDataBinding=getViewDataBinding()
    }


    companion object{
        private const val TAG :String= "VarietiesDialogFragment"
        fun getInstance(): VarietiesDialog {
            return VarietiesDialog()
        }
    }


    override fun showDialog(fragment: FragmentManager) {
        super.show(fragment, TAG) }

     fun dismissDialog() {
        super.dismissDialog(TAG) }

}