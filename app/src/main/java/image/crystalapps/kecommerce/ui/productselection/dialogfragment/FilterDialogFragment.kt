package image.crystalapps.kecommerce.ui.productselection.dialogfragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.ViewModelProvider
import image.crystalapps.ekommercelibraries.ui.base.BaseDialogFragment
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.FilterDataBinding
import image.crystalapps.kecommerce.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class FilterDialogFragment :BaseDialogFragment<FilterViewModel ,FilterDataBinding>() , FilterNavigator{


    companion object{
        private const val TAG :String= "FilterDialogFragment"
        fun getInstance(): FilterDialogFragment {
            return FilterDialogFragment()
        }
    }



    @Inject
    lateinit var mViewModelProviderFactory: ViewModelProviderFactory
    private var mFilterDataBinding:FilterDataBinding?=null



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFilterDataBinding = getViewDataBinding()
        getViewModel().setNavigator(this)
    }


    override fun getBindingVariable(): Int =BR.viewModel

    override fun getViewModel(): FilterViewModel=
        ViewModelProvider(this, mViewModelProviderFactory).get(FilterViewModel::class.java)

    override fun getLayoutId(): Int = R.layout.sort_dialog


    override fun showDialog(fragment: FragmentManager) {
        super.show(fragment,TAG) }



     fun dismissDialog() {
        super.dismissDialog(TAG)
    }
}