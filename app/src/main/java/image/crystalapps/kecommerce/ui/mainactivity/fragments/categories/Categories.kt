package image.crystalapps.kecommerce.ui.mainactivity.fragments.categories

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR

import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.CategoriesListAdapter
import image.crystalapps.kecommerce.databinding.CategoriesFragmentBinding
import image.crystalapps.kecommerce.model.Categories
import image.crystalapps.kecommerce.ui.base.BaseFragment
import androidx.lifecycle.Observer
import image.crystalapps.kecommerce.ui.clothes.ClothesActivity
import image.crystalapps.kecommerce.listeners.OnItemClickListener

@AndroidEntryPoint
class Categories : BaseFragment<CategoriesViewModel, CategoriesFragmentBinding>(),
    OnItemClickListener<Categories> {


    private var mCategoriesFragmentBinding:CategoriesFragmentBinding?=null
    private val mViewModel by viewModels<CategoriesViewModel>()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mCategoriesFragmentBinding=   getViewDataBinding()

        mViewModel.setUpCategories()
        setUpRecyclerView()
    }


    override fun getViewModel(): CategoriesViewModel =mViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_categories
    }

    private fun setUpRecyclerView(){
        mViewModel.categoriesLiveData.observe(viewLifecycleOwner, Observer {list->
            val clothesAdapter = CategoriesListAdapter(this ,mClothItemCallBack)
            clothesAdapter.submitList(list)
            mCategoriesFragmentBinding?.categoriesRecyclerView?.run {
                this.layoutManager = LinearLayoutManager(requireContext() ,
                    LinearLayoutManager.VERTICAL,false)
                this.adapter = clothesAdapter } })
    }


    //Diff Call Back
    private val mClothItemCallBack = object : DiffUtil.ItemCallback<Categories>(){
        override fun areItemsTheSame(oldItem: Categories, newItem: Categories):
                Boolean =false
        override fun areContentsTheSame(oldItem: Categories, newItem: Categories):
                Boolean = oldItem==newItem}

    override fun clickItem(view: View, item: Categories) {
        val intent = Intent(requireContext() , ClothesActivity::class.java)
        intent.putExtra("category" ,item.name)
        startActivity(intent)
    }

}
