package image.crystalapps.kecommerce.ui.mainactivity.fragments.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import image.crystala.MainActivity
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.HiltTestActivity
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.adapter.CategoriesListAdapter
import image.crystalapps.kecommerce.databinding.HomeFragmentBinding
import image.crystalapps.kecommerce.databinding.replaceOnce
import image.crystalapps.kecommerce.listeners.FragmentVisibilityListener
import image.crystalapps.kecommerce.model.Categories
import image.crystalapps.kecommerce.model.NotificationBean
import image.crystalapps.kecommerce.ui.base.BaseFragment
import image.crystalapps.kecommerce.ui.clothes.ClothesActivity
import image.crystalapps.kecommerce.ui.mainactivity.fragments.popular.PopularFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.products.BlogFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.recent.RecentProducts
import image.crystalapps.kecommerce.utils.OnItemClickListener
import kotlinx.android.synthetic.main.fragment_home.*
import java.sql.Date


@AndroidEntryPoint
class Home : BaseFragment<HomeViewModel, HomeFragmentBinding>() ,OnItemClickListener<Categories>{

    private var mHomeFragmentBinding :HomeFragmentBinding?=null
      private lateinit var mMainActivity: MainActivity

    private val mViewModel by viewModels<HomeViewModel>()

    private  lateinit var navController: NavController


    //Diff Call Back
    private val mClothItemCallBack = object : DiffUtil.ItemCallback<Categories>(){
        override fun areItemsTheSame(oldItem: Categories, newItem: Categories):
                Boolean =false
        override fun areContentsTheSame(oldItem: Categories, newItem: Categories):
                Boolean = oldItem==newItem}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mHomeFragmentBinding= getViewDataBinding()

        if(getBaseActivity() is MainActivity) {
            mMainActivity = getBaseActivity() as MainActivity
            mHomeFragmentBinding?.run {
            //    mMainActivity.setSupportActionBar(homeToolbar)
            //    navController = Navigation.findNavController(root)

            }
        }
        else if(getBaseActivity() is HiltTestActivity) {
        } else{
            throw ClassCastException("Home Fragment is not Child Class of BaseActivity")
        }

        mViewModel.setUpCategories()
        initFragments()
        setHasOptionsMenu(true)
        setUpRecyclerView()


//        val date =Date(2019,1,2)
//
//        Firebase.firestore.collection("users").document("7m5pHZ89AecrwnlLKjuoLlZfpMh1")
//            .collection("notifications")
//            .add(NotificationBean("Shahzaib","This is shahzaib Lashari Inform","https://firebasestorage.googleapis.com/v0/b/delicious-food-21577.appspot.com/o/jackets.jpg?alt=media&token=0fcbe68f-9444-4315-ae8a-b36397409604"))

    }

 private fun setUpRecyclerView(){
        mViewModel.categoriesLiveData.observe(viewLifecycleOwner, Observer {list->
            val clothesAdapter = CategoriesListAdapter(this ,mClothItemCallBack)
            clothesAdapter.submitList(list)
            mHomeFragmentBinding?.categoriesRecyclerView?.run {
                this.layoutManager = LinearLayoutManager(requireContext() ,
                    LinearLayoutManager.HORIZONTAL,false)
                this.adapter = clothesAdapter } })
 }



    private fun recentFragment(){
       childFragmentManager.replaceOnce(R.id.recentContainer ,RecentProducts::class.java.name ,{
           val fragment  = RecentProducts()
           fragment.visibilityListener  =      object: FragmentVisibilityListener{
               override fun changeVisibility(isVisible: Boolean) {

                   recentContainer.visibility =if(isVisible)View.VISIBLE else View.GONE
               } }
           fragment }).commit()
   }
    private fun popularFragment(){
        childFragmentManager.replaceOnce(R.id.popularContainer ,PopularFragment::class.java.name ,{
            val fragment  =   PopularFragment()
            fragment.visibilityListener  =      object: FragmentVisibilityListener{
                override fun changeVisibility(isVisible: Boolean) {
                    popularContainer.visibility =if(isVisible)View.VISIBLE else View.GONE } }
            fragment }).commit()
    }
    private fun blogFragment(){
        childFragmentManager.replaceOnce(R.id.blogContainer ,BlogFragment::class.java.name ,{
            val fragment  =  BlogFragment()
            fragment.visibilityListener  = object: FragmentVisibilityListener{
                override fun changeVisibility(isVisible: Boolean) {
                    blogContainer.visibility =if(isVisible)View.VISIBLE else View.GONE } }
            fragment }).commit()
    }

    private fun initFragments(){
       recentFragment()
       popularFragment()
       blogFragment() }


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)


    }

    override fun getViewModel(): HomeViewModel =mViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel}

    override fun getLayoutId(): Int {
    return R.layout.fragment_home }

    override fun clickItem(view: View, item: Categories) {
//     val bundle=   bundleOf("category" to item.name)
//        navController.navigate(R.id.From_Home_To_ClothActivity ,bundle)

            val intent =Intent(mMainActivity , ClothesActivity::class.java)
              intent.putExtra("category" ,item.name)
            startActivity(intent)

    }


    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.toolbarmenu ,menu)
        super.onCreateOptionsMenu(menu, inflater) }


}

