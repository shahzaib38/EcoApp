package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.profiledialog

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.data.database.firebase.FirebaseUserProfile
import image.crystalapps.kecommerce.databinding.ProfileDataBinding
import image.crystalapps.kecommerce.databinding.ProfileDialogDataBinding
import image.crystalapps.kecommerce.ui.base.BaseDialogFragment
import image.crystalapps.kecommerce.ui.mainactivity.MainViewModel


@AndroidEntryPoint
class ProfileDialog :BaseDialogFragment<ProfileDialogViewModel, ProfileDialogDataBinding>() ,ProfileDialogNavigator {

    private val mViewModel by viewModels<ProfileDialogViewModel>()
    private var mProfileDialogDataBinding :ProfileDialogDataBinding?=null

    override fun getBindingVariable(): Int =BR.viewModel

    override fun getViewModel(): ProfileDialogViewModel =mViewModel

    override fun getLayoutId(): Int = R.layout.profile_dialog



    companion object{
        private const val TAG :String= "ProfileDialogFragment"
        private const val DISPLAY_NAME="display_name"
        private const val ARGUMENT_DISPLAY_EXCEPTION="Profile Display Argument is null"
        private const val DATABINDING_NAME_EXCEPTION="Profile Display Argument is null"
        private const val DISPLAY_NAME_CLASS_CAST_EXCEPTION="Profile Dialog Name is Not String Type"

        fun getInstance(name  :String): ProfileDialog {
            val fragmentDialog = ProfileDialog()
            val bundle = Bundle()
            bundle.putString(DISPLAY_NAME, name)
            fragmentDialog.arguments = bundle
            return fragmentDialog }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mProfileDialogDataBinding = getViewDataBinding()
        getViewModel().setNavigator(this)
        displayName()
    }


    private fun displayName(){
        val arguments = arguments?.run {
            get(DISPLAY_NAME)
        }?: throw NullPointerException(ARGUMENT_DISPLAY_EXCEPTION)

        if(arguments is String){
            mProfileDialogDataBinding?.run {
                profileName.text = arguments.toString()
            } ?: throw NullPointerException(DATABINDING_NAME_EXCEPTION)
        } else {
            throw ClassCastException(DISPLAY_NAME_CLASS_CAST_EXCEPTION) }
    }


    override fun showDialog(fragment: FragmentManager) {
        super.show(fragment, TAG) }



     fun dismissDialog() {
        super.dismissDialog(TAG)
    }

    override fun submit() {

        mProfileDialogDataBinding?.run {
                val mEditTextValue=  this.appCompatEditText.text.toString()
                val hintValue=this.profileName.text

       val textName=     when(hintValue){
           resources.getString(R.string.user_name_hint)->{
                    "username"
           }
           resources.getString(R.string.phone_number)->{
               "phoneNumber"
           }
           resources.getString(R.string.address)->{
               "userAddress"
           }

           else->{
               throw NullPointerException(" Edit text is null") }
       }


               val hashMap=  hashMapOf<String ,String>(textName to mEditTextValue )
                FirebaseUserProfile.uploadUserData(hashMap)

                }?:throw NullPointerException("Profile Dialog is Null")


    }


}