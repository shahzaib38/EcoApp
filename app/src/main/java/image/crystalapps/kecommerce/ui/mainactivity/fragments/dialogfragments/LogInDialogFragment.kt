package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.viewModels
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
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.databinding.LoginDialogBinding
import image.crystalapps.kecommerce.databinding.snackBarSetup
import image.crystalapps.kecommerce.ui.base.BaseDialogFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.networkconnection.InternetManagerDialogFragment


@AndroidEntryPoint
class LogInDialogFragment : BaseDialogFragment<LogInViewModel, LoginDialogBinding>()  ,LogInNavigator{

    private var mFirebaseAuthenticationDialogBinding: LoginDialogBinding?=null
    private lateinit var googleSignInClient: GoogleSignInClient
    private  lateinit var mFirebaseAuth :FirebaseAuth
    private lateinit var mMainActivity : MainActivity

    private val mViewModel by viewModels<LogInViewModel>()


    override fun getBindingVariable(): Int {
        return BR.viewModel }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requireActivity().window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        mViewModel.setNavigator(this)
        mFirebaseAuthenticationDialogBinding = getViewDataBinding()

        if(getBaseActivity() is MainActivity) {
            mMainActivity = getBaseActivity() as MainActivity
        }else{
            throw ClassCastException("Login Dialog Fragment is null")
        }


        mFirebaseAuthenticationDialogBinding?.root?.
            snackBarSetup(this ,
                getViewModel().snackBarText ,Snackbar.LENGTH_LONG)


        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken(getString(R.string.default_web_client_id))
            .requestEmail()
            .build()

        googleSignInClient = GoogleSignIn.getClient(mMainActivity, gso)

    mFirebaseAuth =   Firebase.auth

    }

    companion object{
        private const val TAG :String= "FirebaseAuthenticationDialogFragment"
        private const val   RC_SIGN_IN=9125
        fun getInstance(): LogInDialogFragment {
            return LogInDialogFragment()
        }
    }

    override fun getViewModel(): LogInViewModel =mViewModel

    override fun getLayoutId(): Int {
        return R.layout.firebase_authentication_dialog }

    override fun showDialog(fragment: FragmentManager) {
        super.show(fragment,TAG) }

    override fun dismissDialog() {
        super.dismissDialog(TAG) }

    override fun setGoogleAuth(firebaseAuth: FirebaseAuth?) {
        mMainActivity.setGoogleAuth(firebaseAuth) }

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


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                // Google Sign In was successful, authenticate with Firebase
                val account = task.getResult(ApiException::class.java)!!
          //      Log.d(TAG, "firebaseAuthWithGoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
//                 Google Sign In failed, update UI appropriately
//                Log.w(TAG, "Google sign in failed", e)
//                 [START_EXCLUDE]
//                updateUI(null)

                // [END_EXCLUDE]
            }
        }
    }


    //Firebase Auth With Google
    private fun firebaseAuthWithGoogle(idToken: String) {
        // [START_EXCLUDE silent]
  //      showProgressBar()
        // [END_EXCLUDE]
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        mFirebaseAuth.signInWithCredential(credential)
            .addOnCompleteListener(requireActivity()) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information
                 //   Log.d(TAG, "signInWithCredential:success")
               //     val user = auth.currentUser
                //    updateUI(mFirebaseAuth)

                    getViewModel().googleAuth(mFirebaseAuth)

                } else {
                    // If sign in fails, display a message to the user.
                    Log.w(TAG, "signInWithCredential:failure", task.exception)
                    // [START_EXCLUDE]
                 //   val view = binding.mainLayout
                    // [END_EXCLUDE]
               //     Snackbar.make(view, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
                //    updateUI(null)
                    getViewModel().googleAuth(null)
                }

                // [START_EXCLUDE]
            //    hideProgressBar()
                // [END_EXCLUDE]
            }
    }

}