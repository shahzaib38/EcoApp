package image.crystalapps.kecommerce.ui.mainactivity.fragments.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import image.crystala.MainActivity
import image.crystalapps.ekommercelibraries.ui.base.BaseFragment
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.HomeFragmentBinding
import image.crystalapps.kecommerce.databinding.setUpRecyclerView
import image.crystalapps.kecommerce.model.Categories
import image.crystalapps.kecommerce.ui.clothes.ClothesActivity
import image.crystalapps.kecommerce.ui.productselection.dialogfragment.FilterDialogFragment
import image.crystalapps.kecommerce.utils.OnItemClickListener
import image.crystalapps.kecommerce.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class Home : BaseFragment<HomeViewModel,HomeFragmentBinding>() ,OnItemClickListener<Categories>{

    @Inject
    lateinit var mViewModelProviderFactory: ViewModelProviderFactory
    private var mHomeFragmentBinding :HomeFragmentBinding?=null
      private lateinit var mMainActivity: MainActivity
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mHomeFragmentBinding = getViewDataBinding()
        mMainActivity=   getBaseActivity() as MainActivity
        getViewModel().setUpCategories()


        getViewModel().categoriesLiveData.observe(viewLifecycleOwner , Observer {list->
            mHomeFragmentBinding?.run{
                this.root.setUpRecyclerView(this@Home, this.recyclerView ,list)
            }


        })



    }

    override fun getViewModel(): HomeViewModel {
       return ViewModelProvider(this, mViewModelProviderFactory).get(HomeViewModel::class.java)}

    override fun getBindingVariable(): Int {
        return BR.viewModel}

    override fun getLayoutId(): Int {
    return R.layout.fragment_home }

    override fun clickItem(view: View, item: Categories) {
            val intent =Intent(mMainActivity , ClothesActivity::class.java)
              intent.putExtra("category" ,item.name)
            startActivity(intent)

    }


}
