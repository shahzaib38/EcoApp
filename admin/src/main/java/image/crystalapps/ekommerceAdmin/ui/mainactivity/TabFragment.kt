package image.crystalapps.ekommerceAdmin.ui.mainactivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import image.crystalapps.ekommerceAdmin.NavigationUtils.FragmentUtils
import image.crystalapps.ekommerceAdmin.viewmodel.ViewModelProviderFactory

import image.crystalapps.ekommercelibraries.ui.base.BaseFragment
import image.crystalapps.ekommerceAdmin.R
import image.crystalapps.ekommerceAdmin.databinding.*
import javax.inject.Inject
//
//class TabFragment :BaseFragment<MainViewModel>(){
//
//    @Inject
//    lateinit var viewModelProviderFactory: ViewModelProviderFactory
//
//
//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//
//
//        val mainViewModel = getViewModel();
//
//
//        val section =arguments?.getInt(FragmentUtils.FRAGMENT_KEY)
//        return when(section){
//            FragmentUtils.HOME_INDEX->{
//                createHomeView(inflater ,container ) }
//
//            FragmentUtils.CART_INDEX->{
//            createCartView(inflater ,container ) }
//
//            FragmentUtils.ORDER_INDEX ->{
//                createOrderView(inflater ,container)
//
//            }
//            else ->{
//                createHomeView(inflater ,container) } }
//    }
//
//
//    fun createOrderView(inflater: LayoutInflater ,container: ViewGroup? ) :View?{
//       val fragmentOrderBinding=  DataBindingUtil.inflate<FragmentOrderBinding>(inflater ,R.layout.fragment_order ,container,false)
//         fragmentOrderBinding.lifecycleOwner=this
//        fragmentOrderBinding.viewModel =getViewModel()
//        return fragmentOrderBinding.root
//    }
//
//    fun createCartView(inflater: LayoutInflater ,container: ViewGroup?) :View?{
//        val cartBinding= DataBindingUtil.inflate<FragmentCartBinding>(inflater ,R.layout.fragment_cart ,container ,false)
//        cartBinding.lifecycleOwner=this
//        cartBinding.viewModel =getViewModel()
//        return cartBinding.root
//    }
//
//    fun createHomeView(inflater: LayoutInflater ,container: ViewGroup?) :View?{
//   val homeBinding=    DataBindingUtil.inflate<HomeBind>(inflater , R.layout.fragment_home ,container,false)
//        homeBinding.lifecycleOwner=this
//         homeBinding.viewModel =getViewModel()
//        return homeBinding.root
//    }
//
//    companion object {
//        private const val TAG = "TabFragment"
//
//        /**
//         * The fragment argument representing the section number for this
//         * fragment.
//         */
//        private const val ARG_SECTION_NUMBER = "section_number"
//
//        /**
//         * Returns a new instance of this fragment for the given section
//         * number.
//         */
//        fun newInstance(sectionNumber: Int): TabFragment {
//            val args = Bundle().apply {
//                putInt(FragmentUtils.FRAGMENT_KEY, sectionNumber)
//            }
//            return TabFragment().apply { arguments = args }
//        }
//    }
//
//
//
//    override fun getViewModel(): MainViewModel {
//        return ViewModelProvider(this, viewModelProviderFactory).get(
//            MainViewModel::class.java);
//    }
//
//}