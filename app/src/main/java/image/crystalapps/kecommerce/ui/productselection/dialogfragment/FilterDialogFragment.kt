package image.crystalapps.kecommerce.ui.productselection.dialogfragment

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.FilterDataBinding
import image.crystalapps.kecommerce.model.Filter
import image.crystalapps.kecommerce.ui.base.BaseDialogFragment
import image.crystalapps.kecommerce.ui.clothes.ClothesActivity
import image.crystalapps.kecommerce.utils.OnItemClickListener


@AndroidEntryPoint
class FilterDialogFragment : BaseDialogFragment<FilterViewModel, FilterDataBinding>() , FilterNavigator ,SeekBar.OnSeekBarChangeListener ,OnItemClickListener<RatingItem> {


    var step = 1000
    var value :Int =0
    companion object{
        private const val TAG :String= "FilterDialogFragment"
        fun getInstance(): FilterDialogFragment {
            return FilterDialogFragment()
        }
    }

    private var mFilterDataBinding:FilterDataBinding?=null

    private var mCLothesActivity :ClothesActivity?=null

    private val mViewModel by viewModels<FilterViewModel>()



    val mClothItemCallBack = object : DiffUtil.ItemCallback<RatingItem>(){
        override fun areItemsTheSame(oldItem: RatingItem, newItem: RatingItem):
                Boolean =oldItem.rating == newItem.rating
        override fun areContentsTheSame(oldItem: RatingItem, newItem: RatingItem):
                Boolean = false}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mFilterDataBinding = getViewDataBinding()

        if(getBaseActivity() is ClothesActivity) {
            mCLothesActivity = getBaseActivity() as ClothesActivity
        }else{
            throw ClassCastException("Filter Dialog is not Child Class of ClothActivity")
        }


        getViewModel().setNavigator(this)

        mFilterDataBinding?.appCompatSeekBar?.run{
            setOnSeekBarChangeListener(this@FilterDialogFragment) }

        val list = ArrayList<RatingItem>()
        list.add(RatingItem(2))
        list.add(RatingItem(3))
        list.add(RatingItem(4))
        list.add(RatingItem(5))

        if (list != null && list.isNotEmpty()) {
            val clothesAdapter = FilterAdapter(this@FilterDialogFragment, mClothItemCallBack)
            clothesAdapter.submitList(list)
            mFilterDataBinding?.ratingRecyclerview?.run {
                this.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
                this.adapter = clothesAdapter
            }


        }


    }


    override fun getBindingVariable(): Int =BR.viewModel

    override fun getViewModel(): FilterViewModel=mViewModel

    override fun getLayoutId(): Int = R.layout.sort_dialog


    override fun showDialog(fragment: FragmentManager) {
        super.show(fragment,TAG) }

     fun dismissDialog() {
        super.dismissDialog(TAG)
    }




     fun getFilter() : Filter {
        val filter =Filter()
         Toast.makeText(requireActivity() ,value.toString() ,Toast.LENGTH_LONG).show()
        filter.price =value
        return filter }





//
//   private fun getSelectedSortBy():String? =mFilterDataBinding?.run {
//         val selectedItem=   spinnerSort.selectedItem
//        if (selectedItem.equals(R.string.sort_by_rating)){
//            return "avgRating" }
//        if (selectedItem.equals(R.string.sort_by_price)){
//            return "productPrice" }
//        return null
//    }


//    private fun getSortDirection(): Query.Direction? =mFilterDataBinding?.run {
//        val selected = spinnerSort.getSelectedItem() as String
//        if (getString(R.string.sort_by_rating) == selected) {
//            return Query.Direction.DESCENDING
//        }
//        if (getString(R.string.sort_by_price) == selected) {
//            return Query.Direction.ASCENDING }
//
//        return null
//    }

    override fun filter() {
        mCLothesActivity?.run {
            onFilter(getFilter())
        }
        dismissDialog()

        }

    override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
         value = progress * step
        mFilterDataBinding?.lessThan?.setText("LessThan  $value")

        Toast.makeText(mCLothesActivity ,value.toString() ,Toast.LENGTH_LONG).show()
    }

    override fun onStartTrackingTouch(seekBar: SeekBar?) {
    }

    override fun onStopTrackingTouch(seekBar: SeekBar?) {
        //val value = progress * step

       // mFilterDataBinding?.lessThan?.setText("LessThan  $value")
    }

    override fun clickItem(view: View, item: RatingItem) {
        Toast.makeText(mCLothesActivity,item.rating.toString() ,Toast.LENGTH_LONG).show() }


}