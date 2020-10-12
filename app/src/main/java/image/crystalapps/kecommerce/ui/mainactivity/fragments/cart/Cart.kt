package image.crystalapps.kecommerce.ui.mainactivity.fragments.cart

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import image.crystalapps.Products
import image.crystalapps.ekommercelibraries.ui.base.BaseFragment
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.CartFragmentBinding
import image.crystalapps.kecommerce.ui.clothes.ClothesAdapter
import image.crystalapps.kecommerce.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class Cart : BaseFragment<CartViewModel ,CartFragmentBinding>() {

    @Inject
    lateinit var mViewModelProviderFactory: ViewModelProviderFactory
     private var mCartFragmentBinding :CartFragmentBinding?=null

    val mClothItemCallBack = object : DiffUtil.ItemCallback<Products>(){
        override fun areItemsTheSame(oldItem: Products, newItem: Products):
                Boolean =oldItem.productId == newItem.productId
        override fun areContentsTheSame(oldItem: Products, newItem: Products):
                Boolean = oldItem==newItem}


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mCartFragmentBinding= getViewDataBinding()


        getViewModel().allCartLiveDataManager.observe(viewLifecycleOwner, Observer { list ->
            if(list!=null && list.isNotEmpty()) {
                val clothesAdapter = CartAdapter(mClothItemCallBack)
                clothesAdapter.submitList(list)
                mCartFragmentBinding?.cartRecyclerview?.run {
                    this.layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    this.adapter = clothesAdapter } }
        }

        )
    }

    override fun getViewModel(): CartViewModel {
        return ViewModelProvider(this, mViewModelProviderFactory).get(
            CartViewModel::class.java); }

    override fun getBindingVariable(): Int {
        return BR.viewModel }

    override fun getLayoutId(): Int {
        return R.layout.fragment_cart }

}
