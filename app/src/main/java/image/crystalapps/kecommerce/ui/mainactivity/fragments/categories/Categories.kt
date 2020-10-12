package image.crystalapps.kecommerce.ui.mainactivity.fragments.categories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import image.crystalapps.ekommercelibraries.ui.base.BaseFragment
import image.crystalapps.kecommerce.BR

import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.CategoriesFragmentBinding
import image.crystalapps.kecommerce.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class Categories : BaseFragment<CategoriesViewModel ,CategoriesFragmentBinding>() {


    @Inject
    lateinit var mViewModelProviderFactory: ViewModelProviderFactory

    private var mCategoriesFragmentBinding:CategoriesFragmentBinding?=null


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mCategoriesFragmentBinding=   getViewDataBinding()
    }


    override fun getViewModel(): CategoriesViewModel {
        return ViewModelProvider(this, mViewModelProviderFactory).get(
            CategoriesViewModel::class.java)}

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_categories
    }

}
