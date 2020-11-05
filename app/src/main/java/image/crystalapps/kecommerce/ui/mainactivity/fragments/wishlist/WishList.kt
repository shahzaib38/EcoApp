package image.crystalapps.kecommerce.ui.mainactivity.fragments.wishlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.WishListFragmentBinding
import image.crystalapps.kecommerce.ui.base.BaseFragment


@AndroidEntryPoint
class WishList : BaseFragment<WishListViewModel, WishListFragmentBinding>() {


    private var mWishListFragmentBinding:WishListFragmentBinding?=null


    private val mViewModel by viewModels<WishListViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mWishListFragmentBinding= getViewDataBinding() }


    override fun getViewModel(): WishListViewModel =mViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel }

    override fun getLayoutId(): Int {
        return R.layout.fragment_wish_list }


}
