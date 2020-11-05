package image.crystalapps.kecommerce.ui.mainactivity.fragments.home

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import image.crystala.MainActivity
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.HiltTestActivity
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.HomeFragmentBinding
import image.crystalapps.kecommerce.databinding.replaceOnce
import image.crystalapps.kecommerce.databinding.setUpRecyclerView
import image.crystalapps.kecommerce.listeners.FragmentVisibilityListener
import image.crystalapps.kecommerce.model.Categories
import image.crystalapps.kecommerce.model.Clothes
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.ui.base.BaseFragment
import image.crystalapps.kecommerce.ui.clothes.ClothesActivity
import image.crystalapps.kecommerce.ui.mainactivity.fragments.cart.Cart
import image.crystalapps.kecommerce.ui.mainactivity.fragments.popular.PopularFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.products.MainProducts
import image.crystalapps.kecommerce.utils.OnItemClickListener
import kotlinx.android.synthetic.main.fragment_home.*


@AndroidEntryPoint
class Home : BaseFragment<HomeViewModel, HomeFragmentBinding>() ,OnItemClickListener<Categories>{

    private var mHomeFragmentBinding :HomeFragmentBinding?=null
      private lateinit var mMainActivity: MainActivity

    private val mViewModel by viewModels<HomeViewModel>()

    private  lateinit var navController: NavController


    //Diff Call Back
    private val mClothItemCallBack = object : DiffUtil.ItemCallback<Clothes>(){
        override fun areItemsTheSame(oldItem: Clothes, newItem: Clothes):
                Boolean =false
        override fun areContentsTheSame(oldItem: Clothes, newItem: Clothes):
                Boolean = oldItem==newItem}

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mHomeFragmentBinding= getViewDataBinding()

        if(getBaseActivity() is MainActivity) {

            mMainActivity = getBaseActivity() as MainActivity
            mHomeFragmentBinding?.run {
                mMainActivity.setSupportActionBar(homeToolbar)
                navController = Navigation.findNavController(root)
            }

        }
        else if(getBaseActivity() is HiltTestActivity) {
        } else{
            throw ClassCastException("Home Fragment is not Child Class of BaseActivity")
        }


        mViewModel.setUpCategories()
//
//       mViewModel.categoriesLiveData.observe(viewLifecycleOwner , categoriesObserver)




        initFragments()
        setHasOptionsMenu(true)
    }


//   private val categoriesObserver= Observer<List<Categories>> {list->
//        mHomeFragmentBinding?.run{
//            this.root.setUpRecyclerView(this@Home, this.recyclerView ,list)
//        }?:throw NullPointerException("Home Fragment Binding is null")
//
//    }



    fun initFragments(){
        childFragmentManager.replaceOnce(R.id.recentContainer ,Cart::class.java.name ,{
            val fragment  =   MainProducts()
            fragment.visibilityListener  =      object: FragmentVisibilityListener{
                override fun changeVisibility(isVisible: Boolean) {

                    recentContainer.visibility =if(isVisible)View.VISIBLE else View.INVISIBLE


                }
            }
            fragment
        }
        ).commit()

        childFragmentManager.replaceOnce(R.id.popularContainer ,Cart::class.java.name ,{
            val fragment  =   PopularFragment()
            fragment.visibilityListener  =      object: FragmentVisibilityListener{
                override fun changeVisibility(isVisible: Boolean) {

                    recentContainer.visibility =if(isVisible)View.VISIBLE else View.INVISIBLE


                }
            }
            fragment
        }
        ).commit()
    }


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
