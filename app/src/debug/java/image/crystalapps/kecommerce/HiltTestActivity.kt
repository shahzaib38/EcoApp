package image.crystalapps.kecommerce

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import image.crystala.MainActivity
import image.crystalapps.kecommerce.databinding.TestDataBinding
import image.crystalapps.kecommerce.ui.base.BaseActivity
import image.crystalapps.kecommerce.ui.clothes.ClothesViewModel
import image.crystalapps.kecommerce.ui.mainactivity.MainViewModel


@AndroidEntryPoint
class HiltTestActivity : BaseActivity<MainViewModel ,TestDataBinding>() {

    private val mViewModel by viewModels<MainViewModel>()


    override fun getBindingVariable(): Int =BR.viewModel

    override fun getLayoutId(): Int =R.layout.test

    override fun getViewModel(): MainViewModel=mViewModel


}
