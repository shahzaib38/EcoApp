package image.crystalapps.kecommerce.ui.filter

import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.FilterActivityDAtaBinding
import image.crystalapps.kecommerce.ui.base.BaseActivity


@AndroidEntryPoint
class FilterActivity : BaseActivity<FilterViewModel, FilterActivityDAtaBinding>() {


   // @Inject
    //lateinit var mViewModelProviderFactory: ViewModelProviderFactory
    private val mViewModel by viewModels<FilterViewModel>()

    override fun getBindingVariable(): Int =BR.viewModel

    override fun getLayoutId(): Int {
        return R.layout.filter_activity }

    override fun getViewModel(): FilterViewModel= mViewModel


}