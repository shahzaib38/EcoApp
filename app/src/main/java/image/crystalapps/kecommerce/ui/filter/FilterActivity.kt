package image.crystalapps.kecommerce.ui.filter



import androidx.lifecycle.ViewModelProvider
import image.crystalapps.ekommercelibraries.ui.base.BaseActivity
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.FilterActivityDAtaBinding
import image.crystalapps.kecommerce.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class FilterActivity :BaseActivity<FilterViewModel ,FilterActivityDAtaBinding>() {


    @Inject
    lateinit var mViewModelProviderFactory: ViewModelProviderFactory

    override fun getBindingVariable(): Int =BR.viewModel

    override fun getLayoutId(): Int {
        return R.layout.filter_activity
    }
    override fun getViewModel(): FilterViewModel= ViewModelProvider(this, mViewModelProviderFactory).get(
        FilterViewModel::class.java)


}