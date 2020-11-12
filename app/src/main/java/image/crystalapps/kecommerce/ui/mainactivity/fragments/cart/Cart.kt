package image.crystalapps.kecommerce.ui.mainactivity.fragments.cart

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import image.crystala.MainActivity
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.HiltTestActivity
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.CartFragmentBinding
import image.crystalapps.kecommerce.extensions.multiple
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_cart.*

@AndroidEntryPoint
class Cart : BaseFragment<CartViewModel, CartFragmentBinding>() , CartNavigator {

     private var mCartFragmentBinding :CartFragmentBinding?=null

      private val mClothItemCallBack = object : DiffUtil.ItemCallback<Cart>(){
        override fun areItemsTheSame(oldItem: Cart, newItem: Cart):
                Boolean =false
        override fun areContentsTheSame(oldItem: Cart, newItem: Cart):
                Boolean = oldItem ==newItem }

      private val mViewModel by viewModels<CartViewModel>()
      private var mainActivity :MainActivity?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mCartFragmentBinding = getViewDataBinding()
        getViewModel().setNavigator(this)
        if(getBaseActivity() is MainActivity) {
             mainActivity = getBaseActivity() as MainActivity
             }else if(getBaseActivity() is HiltTestActivity ){}


        mViewModel.allCartLiveDataManager.observe(viewLifecycleOwner, allCartObserver)

    }




    override fun getViewModel(): CartViewModel =mViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel }

    override fun getLayoutId(): Int {
        return R.layout.fragment_cart }




    //Cart callBacks
   private val allCartObserver = Observer<List<Cart>> {list->
        if(list!=null ) {
            val clothesAdapter = CartAdapter(mViewModel,mClothItemCallBack)
            clothesAdapter.submitList(list)
            mViewModel.setTotalPrice(list.multiple().toString())
            mViewModel.setItems(list.size)
            mCartFragmentBinding?.run {
                cartRecyclerview.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                cartRecyclerview.adapter = clothesAdapter
            }
           }


    }

    override fun checkOut() {
        val totalText=   totalId.text
        Toast.makeText(requireContext() ,totalText.toString() ,Toast.LENGTH_LONG).show()

//        val intent = Intent(requireContext() ,CheckOut::class.java)
//        intent.putExtra("array_list" ,arrayList)
//        intent.putExtra("total" ,total)
//        startActivity(intent)

    }


}