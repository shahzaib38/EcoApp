package image.crystalapps.kecommerce.ui.mainactivity.fragments.profile

import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import image.crystala.MainActivity
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.HiltTestActivity
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.ProfileDataBinding
import image.crystalapps.kecommerce.databinding.setprofile
import image.crystalapps.kecommerce.ui.base.BaseFragment
import image.crystalapps.kecommerce.ui.mainactivity.MainNavigator
import image.crystalapps.kecommerce.ui.mainactivity.MainViewModel
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.profiledialog.ProfileDialog


@AndroidEntryPoint
class Profile :BaseFragment<ProfileViewModel,ProfileDataBinding>() ,ProfileNavigator{


    private val mViewModel by viewModels<ProfileViewModel>()

    private var mProfileDatabinding : ProfileDataBinding?=null

    override fun getBindingVariable(): Int= BR.viewModel
    override fun getLayoutId(): Int =R.layout.profile
    override fun getViewModel(): ProfileViewModel = mViewModel

    private var mMainActivity :MainActivity?=null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mProfileDatabinding=   getViewDataBinding()
        getViewModel().setNavigator(this)
        displayProfileName() }


    private fun displayProfileName(){
        if(getBaseActivity() is MainActivity) {
            mMainActivity = getBaseActivity() as MainActivity

        }else if(getBaseActivity() is HiltTestActivity){

        } else
        { throw ClassCastException(PROFILE_CAST_EXCEPTION) }
//
//        mProfileDatabinding?.run {
//            mViewModel.getUserProfile().observe(viewLifecycleOwner , Observer {userProfile->
//                root.setprofile(userProfile) })
//        }?:throw NullPointerException(PROFILE_DataBinding_EXCEPTION)
//

    }


    override fun openProfileDialog(view: View) {
                if(view is TextView) {
                    ProfileDialog.getInstance(view.hint.toString())
                        .showDialog(mMainActivity!!.supportFragmentManager) }
    }


    companion object{

        private const val PROFILE_CAST_EXCEPTION="Profile Fragment is not Child Class of BaseActivity"
       private const val PROFILE_DataBinding_EXCEPTION="profile DataBinding is Empty"


    }

}