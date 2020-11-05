package image.crystalapps.kecommerce.ui.mainactivity.fragments.categories

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR

import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.CategoriesFragmentBinding
import image.crystalapps.kecommerce.ui.base.BaseFragment

@AndroidEntryPoint
class Categories : BaseFragment<CategoriesViewModel, CategoriesFragmentBinding>() {


    private var mCategoriesFragmentBinding:CategoriesFragmentBinding?=null
    private val mViewModel by viewModels<CategoriesViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mCategoriesFragmentBinding=   getViewDataBinding()
    }


    override fun getViewModel(): CategoriesViewModel =mViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_categories
    }

}
