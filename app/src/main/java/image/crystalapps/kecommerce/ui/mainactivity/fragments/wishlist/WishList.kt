package image.crystalapps.kecommerce.ui.mainactivity.fragments.wishlist

import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import image.crystalapps.ekommercelibraries.ui.base.BaseFragment
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.WishListFragmentBinding
import image.crystalapps.kecommerce.viewmodel.ViewModelProviderFactory
import javax.inject.Inject


class WishList : BaseFragment<WishListViewModel ,WishListFragmentBinding>() {

    @Inject
    lateinit var mViewModelProviderFactory: ViewModelProviderFactory

    private var mWishListFragmentBinding:WishListFragmentBinding?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mWishListFragmentBinding= getViewDataBinding() }


    override fun getViewModel(): WishListViewModel {
        return ViewModelProvider(this, mViewModelProviderFactory).get(
            WishListViewModel::class.java)

    }

    override fun getBindingVariable(): Int {
        return BR.viewModel }

    override fun getLayoutId(): Int {
        return R.layout.fragment_wish_list }


}
