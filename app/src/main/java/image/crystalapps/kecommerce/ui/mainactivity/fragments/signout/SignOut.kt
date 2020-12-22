package image.crystalapps.kecommerce.ui.mainactivity.fragments.signout

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import image.crystala.MainActivity
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.databinding.BlankDialogBinding
import image.crystalapps.kecommerce.databinding.LoginDialogBinding
import image.crystalapps.kecommerce.databinding.snackBarSetup
import image.crystalapps.kecommerce.ui.base.BaseDialogFragment
import image.crystalapps.kecommerce.ui.base.BaseFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.LogInDialogFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.LogInNavigator
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.LogInViewModel
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.networkconnection.InternetManagerDialogFragment


//@AndroidEntryPoint
//class SignOut : BaseFragment<SignOutViewModel, BlankDialogBinding>() {
//
//    private var mSignOutFragmentBinding :BlankDialogBinding?=null
//
//
//    private val mViewModel by viewModels<SignOutViewModel>()
//
//
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        mSignOutFragmentBinding=     getViewDataBinding()
//        showLoginDialog()
//    }
//
//   private fun showLoginDialog(){
//       LogInDialogFragment.getInstance().showDialog(requireActivity().supportFragmentManager)
//
//   }
//
//    override fun getViewModel(): SignOutViewModel =mViewModel
//
//    override fun getBindingVariable(): Int {
//        return BR.viewModel
//    }
//
//    override fun getLayoutId(): Int {
//        return R.layout.blank_fragment }
//
//
//}


@AndroidEntryPoint
class SignOut : BaseFragment<SignOutViewModel, LoginDialogBinding>()  ,
    LogInNavigator , FirebaseAuth.AuthStateListener {

    private var mFirebaseAuthenticationDialogBinding: LoginDialogBinding?=null
    private lateinit var googleSignInClient: GoogleSignInClient
    private  lateinit var mFirebaseAuth : FirebaseAuth
    private lateinit var mMainActivity : MainActivity

    private val mViewModel by viewModels<SignOutViewModel>()


    override fun getBindingVariable(): Int {
        return BR.viewModel }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
      //  mViewModel.setNavigator(this)
        mFirebaseAuthenticationDialogBinding = getViewDataBinding()

        if(getBaseActivity() is MainActivity) {
            mMainActivity = getBaseActivity() as MainActivity
        }else{
            throw ClassCastException("Login Dialog Fragment is null")
        }

//
//        mFirebaseAuthenticationDialogBinding?.root?.
//            snackBarSetup(this ,
//                getViewModel().snackBarText , Snackbar.LENGTH_LONG)


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(mMainActivity, gso)

        mFirebaseAuth =   Firebase.auth

        mFirebaseAuthenticationDialogBinding?.authinclude?.signoutauth?.setOnClickListener {
            mFirebaseAuth.signOut() }





    }

//    fun checkAccount(){
//
//        mViewModel.accountDetails.observe(viewLifecycleOwner , Observer{
//
//
//        })
//
//
//    }


    companion object{
        private const val TAG :String= "FirebaseAuthenticationDialogFragment"
        private const val   RC_SIGN_IN=9125
        fun getInstance(): LogInDialogFragment {
            return LogInDialogFragment()
        }
    }

    override fun getViewModel(): SignOutViewModel =mViewModel

    override fun getLayoutId(): Int {
        return R.layout.firebase_authentication_dialog }


    override fun setGoogleAuth(firebaseAuth: FirebaseAuth?) {
        mMainActivity.setGoogleAuth(firebaseAuth) }

    override fun signOut() {

        mFirebaseAuth.signOut()
    }

    private fun  showNetworkDialog(){
        InternetManagerDialogFragment.getInstance().showDialog(requireActivity().supportFragmentManager) }


    override fun signIn() {
        println("Sign In")

        if (isInternetAvailable()) {
            val signInIntent = googleSignInClient.signInIntent
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }else{
            showNetworkDialog()

        }
    }

    override fun dismissDialog() {

    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                //firebaseAuthWithGoogle(account.idToken!!)

            } catch (e: ApiException) {

            }
        }
    }

    override fun onAuthStateChanged(firebaseAuth : FirebaseAuth) {
        mViewModel.isLogin(firebaseAuth)

        Toast.makeText(context, "user is logged in" ,Toast.LENGTH_LONG).show()
    }


}


