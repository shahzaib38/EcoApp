package image.crystalapps.kecommerce.ui.address

import android.content.Context
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.viewModels
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.AddressDataBinding
import image.crystalapps.kecommerce.ui.base.BaseActivity


@AndroidEntryPoint
class AddressActivity :BaseActivity<AddressViewModel , AddressDataBinding>() {


    val mViewModel by viewModels<AddressViewModel>()

    private var mAddressDataBinding :AddressDataBinding?=null

    override fun getBindingVariable(): Int  =BR.viewModel
    override fun getLayoutId(): Int = R.layout.address_layout
    override fun getViewModel(): AddressViewModel =mViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
      mAddressDataBinding =  getViewDataBinding()

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN)


    }

}