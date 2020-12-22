package image.crystalapps.kecommerce.ui.clothes.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.Query
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.SortDataBinding
import image.crystalapps.kecommerce.model.Filter
import image.crystalapps.kecommerce.model.Sort
import image.crystalapps.kecommerce.ui.base.BaseDialogFragment
import image.crystalapps.kecommerce.ui.clothes.ClothesActivity
import image.crystalapps.kecommerce.utils.ClothesUtils
import image.crystalapps.kecommerce.listeners.OnItemClickListener


@AndroidEntryPoint
class SortDialogFragment : BaseDialogFragment<SortViewModel, SortDataBinding>() ,SortNavigator ,
    OnItemClickListener<Sort> {


 private var mSortDataBinding :SortDataBinding?=null


    private val mViewModel by viewModels<SortViewModel>()


    override fun getBindingVariable(): Int =BR.viewModel
    override fun getViewModel(): SortViewModel= mViewModel


    override fun getLayoutId(): Int= R.layout.sort_layout


    private  var mClothActivity :ClothesActivity?=null


    companion object{
        private const val TAG :String= "SortaaDialogFragment"
        fun getInstance(): SortDialogFragment {
            return SortDialogFragment()
        }
    }


  private  val mSortItemCallBack = object : DiffUtil.ItemCallback<Sort>(){
        override fun areItemsTheSame(oldItem: Sort, newItem: Sort):
                Boolean =oldItem.value == newItem.value
        override fun areContentsTheSame(oldItem: Sort, newItem: Sort):
                Boolean = false}


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mSortDataBinding = getViewDataBinding()
        mViewModel.setNavigator(this)


        if(getBaseActivity() is ClothesActivity) {
            mClothActivity = getBaseActivity() as ClothesActivity
        }else{
            throw ClassCastException("SortDialog is not Child of Cloth Activity")
        }


        val list = arrayListOf<Sort>()
        list.add(Sort(getString(R.string.price_highToLow)))
        list.add(Sort(getString(R.string.price_lowToHigh)))
        list.add(Sort(getString(R.string.rating_highToLow)))


        if (list != null && list.isNotEmpty()) {
            val clothesAdapter = SortAdapter(this, mSortItemCallBack)
            clothesAdapter.submitList(list)
            mSortDataBinding?.sortRecyclerview?.run {
                this.layoutManager =
                    LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
                this.adapter = clothesAdapter
            }


        }
    }


    override fun showDialog(fragment: FragmentManager) {
        super.show(fragment,TAG) }



     fun dismissDialog() {
        super.dismissDialog(TAG)
    }

    override fun clickItem(view: View, item: Sort) {
        mClothActivity?.run {
            onFilter(getFilters(item.value))
        }
        dismissDialog() }

   private fun getSortSelectedSortBy(value :String) :String?{
       if (getString(R.string.price_highToLow).equals(value)){
           return ClothesUtils.Product_Price }

       if (getString(R.string.price_lowToHigh).equals(value)){
           return ClothesUtils.Product_Price}

       if (getString(R.string.rating_highToLow).equals(value)){
           return ClothesUtils.Product_Rating }
       return null }

   private fun getSortDirection(value :String) :Query.Direction?{
       if (getString(R.string.price_highToLow).equals(value)){
           return Query.Direction.DESCENDING }

       if (getString(R.string.price_lowToHigh).equals(value)){
           return Query.Direction.ASCENDING }

       if (getString(R.string.rating_highToLow).equals(value)){
           return Query.Direction.DESCENDING }
       return null }


   private fun getFilters(value :String?) :Filter{
        val filters =Filter()
        if (value!=null) {
            filters.sortBy = getSortSelectedSortBy(value)
            filters.sortDirection = getSortDirection(value) }

        return filters }

}