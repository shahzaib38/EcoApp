package image.crystalapps.ekommerceAdmin.ui.womenfashion

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import image.crystalapps.ekommerceAdmin.BR
import image.crystalapps.ekommerceAdmin.R
import image.crystalapps.ekommerceAdmin.viewmodel.ViewModelProviderFactory
import image.crystalapps.ekommercelibraries.ui.base.BaseActivity
import javax.inject.Inject
import image.crystalapps.ekommerceAdmin.databinding.WomenFashionBinding
import image.crystalapps.ekommerceAdmin.ui.kidfashion.KidFashionViewModel

class WomenFashion : BaseActivity<KidFashionViewModel ,WomenFashionBinding>() {



    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }



    override fun getBindingVariable(): Int {
        return  BR.viewModel }

    override fun getLayoutId(): Int {
        return R.layout.activity_women_fashion
    }

    override fun getViewModel(): KidFashionViewModel {
        return  ViewModelProvider(this, viewModelProviderFactory).get(
            KidFashionViewModel::class.java);
    }
}
