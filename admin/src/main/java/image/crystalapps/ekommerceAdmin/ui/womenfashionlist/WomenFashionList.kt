package image.crystalapps.ekommerceAdmin.ui.womenfashionlist

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import image.crystalapps.ekommerceAdmin.BR
import image.crystalapps.ekommerceAdmin.R
import image.crystalapps.ekommerceAdmin.databinding.WomenFashionListBinding
import image.crystalapps.ekommerceAdmin.viewmodel.ViewModelProviderFactory
import image.crystalapps.ekommercelibraries.ui.base.BaseActivity
import javax.inject.Inject

class WomenFashionList :  BaseActivity<WomenFashionListViewModel, WomenFashionListBinding>() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val menFashionListBinding = getViewDataBinding()
        menFashionListBinding?.viewModel=getViewModel()


    }


    override fun getBindingVariable(): Int {
        return  BR.viewModel }

    override fun getLayoutId(): Int {
        return R.layout.activity_women_fashion_list
    }

    override fun getViewModel(): WomenFashionListViewModel {
        return  ViewModelProvider(this, viewModelProviderFactory).get(
            WomenFashionListViewModel::class.java);
    }

}
