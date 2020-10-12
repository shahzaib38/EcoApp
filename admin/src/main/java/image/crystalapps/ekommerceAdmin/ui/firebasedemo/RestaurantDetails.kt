package image.crystalapps.ekommerceAdmin.ui.firebasedemo

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import image.crystalapps.ekommerceAdmin.BR
import image.crystalapps.ekommerceAdmin.R
import image.crystalapps.ekommercelibraries.ui.base.BaseActivity
import  image.crystalapps.ekommerceAdmin.databinding.RestaurantBinding
import image.crystalapps.ekommercelibraries.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class RestaurantDetails : BaseActivity<RestaurantViewModel ,RestaurantBinding>() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewDataBinding = getViewDataBinding()
    }

    override fun getBindingVariable(): Int {
   return  BR.viewModel
    }

    override fun getLayoutId(): Int {


        return R.layout.activity_restaurant_details
    }

    override fun getViewModel(): RestaurantViewModel {
        return ViewModelProvider(this,viewModelProviderFactory).get(RestaurantViewModel::class.java)
    }

}
