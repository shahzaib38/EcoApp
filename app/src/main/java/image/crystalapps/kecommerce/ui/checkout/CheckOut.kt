package image.crystalapps.kecommerce.ui.checkout

import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.firestore.QuerySnapshot
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.CheckOutDataBinding
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.ui.base.BaseActivity


@AndroidEntryPoint
class CheckOut : BaseActivity<CheckOutViewModel, CheckOutDataBinding>() {


    private val mViewModel by viewModels<CheckOutViewModel>()
       private var mCheckOutDatabinding :CheckOutDataBinding?=null
    override fun getBindingVariable(): Int =BR.viewModel
    override fun getLayoutId(): Int = R.layout.checkout_layout
    override fun getViewModel(): CheckOutViewModel =mViewModel


    //Diff Call Back
    private val mClothItemCallBack = object : DiffUtil.ItemCallback<Cart>(){
        override fun areItemsTheSame(oldItem: Cart, newItem: Cart):
                Boolean =false
        override fun areContentsTheSame(oldItem: Cart, newItem: Cart):
                Boolean = oldItem==newItem}


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          mCheckOutDatabinding = getViewDataBinding()


        if(intent!=null){
            val list= intent.getParcelableArrayListExtra<Cart>("array_list")
            val total=intent.getIntExtra("total",0)

            mCheckOutDatabinding?.run {
                this.totalId.text=total.toString()
            }?:throw NullPointerException("CheckOut DataBinding is null")

            if (list != null) {
                val clothesAdapter = CheckOutAdapter(mViewModel, mClothItemCallBack)
                clothesAdapter.submitList(list)
                mCheckOutDatabinding?.checkout?.run {
                    this.layoutManager =
                        LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                    this.adapter = clothesAdapter }

            } else  throw NullPointerException("CheckOut List is null")
            } else  throw NullPointerException("Intent is null")

    }



}