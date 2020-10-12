package image.crystalapps.ekommerceAdmin.ui.mainactivity.fragments.home

import  android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import image.crystalapps.ekommerceAdmin.BR
import image.crystalapps.ekommerceAdmin.R

import image.crystalapps.ekommerceAdmin.databinding.HomeDataBinding
import image.crystalapps.ekommerceAdmin.viewmodel.ViewModelProviderFactory
import image.crystalapps.ekommercelibraries.ui.base.BaseFragment
import javax.inject.Inject


class Home : BaseFragment<HomeViewModel,HomeDataBinding>() {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getViewDataBinding()

    }

    override fun getViewModel(): HomeViewModel {
        return ViewModelProvider(this, viewModelProviderFactory).get(
            HomeViewModel::class.java)}

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
         return R.layout.fragment_home
    }


}
