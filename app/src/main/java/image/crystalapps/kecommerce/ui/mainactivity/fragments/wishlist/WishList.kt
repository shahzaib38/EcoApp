package image.crystalapps.kecommerce.ui.mainactivity.fragments.wishlist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.WishListFragmentBinding
import image.crystalapps.kecommerce.model.WishModel
import image.crystalapps.kecommerce.ui.base.BaseFragment


@AndroidEntryPoint
class WishList : BaseFragment<WishListViewModel, WishListFragmentBinding>() {


    private var mWishListFragmentBinding:WishListFragmentBinding?=null


    private val mViewModel by viewModels<WishListViewModel>()



    private val mClothItemCallBack = object : DiffUtil.ItemCallback<WishModel>(){
        override fun areItemsTheSame(oldItem: WishModel, newItem: WishModel):
                Boolean =false
        override fun areContentsTheSame(oldItem: WishModel, newItem: WishModel):
                Boolean = oldItem ==newItem }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mWishListFragmentBinding= getViewDataBinding()
        setUpRecyclerView() }


    private fun setUpRecyclerView(){
//        mViewModel.allCartLiveDataManager.observe(viewLifecycleOwner, Observer {list->
//
//            if(list!=null ) {
//                val clothesAdapter =
//                    WishListAdapter(
//                        mClothItemCallBack)
//
//                clothesAdapter.submitList(list)
//
//                mWishListFragmentBinding?.run {
//                    wishRecyclerview.layoutManager =
//                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
//                    wishRecyclerview.adapter = clothesAdapter
//
//                }
//            }
//
//        })


    }


    override fun getViewModel(): WishListViewModel =mViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel }

    override fun getLayoutId(): Int {
        return R.layout.fragment_wish_list }


}
