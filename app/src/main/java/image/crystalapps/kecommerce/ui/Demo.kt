//package image.crystalapps.kecommerce.ui
//
//import android.content.Intent
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.util.Log
//import android.widget.Button
//import android.widget.Toast
//import androidx.drawerlayout.widget.DrawerLayout
//import androidx.navigation.NavController
//import androidx.navigation.findNavController
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.navigation.ui.navigateUp
//import androidx.navigation.ui.setupActionBarWithNavController
//import androidx.navigation.ui.setupWithNavController
//import com.google.android.gms.auth.api.signin.GoogleSignIn
//import com.google.android.gms.auth.api.signin.GoogleSignInClient
//import com.google.android.gms.auth.api.signin.GoogleSignInOptions
//import com.google.android.gms.common.api.ApiException
//import com.google.android.material.navigation.NavigationView
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.GoogleAuthProvider
//import image.crystalapps.kecommerce.R
//
//class Demo : AppCompatActivity() {
//    private lateinit var auth: FirebaseAuth
//    private  val RC_SIGN_IN = 9100
//    private lateinit var mDrawer: DrawerLayout
//    private lateinit var appBarConfiguration: AppBarConfiguration
////    private lateinit var googleSignInClient: GoogleSignInClient
////    private lateinit var googleSignInClient: GoogleSignInClient
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_demo)
//    setupNavigationDrawer()
////        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
////            .requestIdToken(getString(R.string.default_web_client_id))
////            .requestEmail()
////            .build()
////
////        googleSignInClient = GoogleSignIn.getClient(this, gso)
////
////       auth =FirebaseAuth.getInstance()
//      //  findViewById<Button>(R.id.firebasesignin).setOnClickListener { signIn() }
//
//    val navController: NavController = findNavController(R.id.nav_host_fragment)
//    appBarConfiguration =
//        AppBarConfiguration.Builder()
//            .setDrawerLayout(mDrawer)
//            .build()
//    setupActionBarWithNavController(navController, appBarConfiguration)
//    findViewById<NavigationView>(R.id.nav_view)
//        .setupWithNavController(navController)
//
//    }
//
//
//    override fun onSupportNavigateUp(): Boolean {
//        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration) ||
//                super.onSupportNavigateUp()
//    }
//    private  fun setupNavigationDrawer(){
//
//        mDrawer =(findViewById<DrawerLayout>(R.id.drawer_layout))
//            .apply {
//                setStatusBarBackground(R.color.colorPrimaryDark)
//            }
//
//
//    }
//
//
//
//
//
//    private fun UnlockDrawer(){
//        mDrawer?.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED) }
////    private fun signIn() {
////        val signInIntent = googleSignInClient.signInIntent
////        startActivityForResult(signInIntent, RC_SIGN_IN)
////    }
//
//
//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
//        if (requestCode == RC_SIGN_IN) {
//            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
//            try {
//                // Google Sign In was successful, authenticate with Firebase
//                val account = task.getResult(ApiException::class.java)!!
//                Toast.makeText(this ,"sign call" , Toast.LENGTH_LONG).show()
//
//                Log.i("testing", "firebaseAuthWithGoogle:" + account.id)
//                firebaseAuthWithGoogle(account.idToken!!)
//            } catch (e: ApiException) {
//                Toast.makeText(this ,"sign Exception" , Toast.LENGTH_LONG).show()
//
//                // Google Sign In failed, update UI appropriately
//                Log.i("testing", "Google sign in failed", e)
//                // [START_EXCLUDE]
//                //     updateUI(null)
//                // [END_EXCLUDE]
//            }
//        }
//    }
//    private fun firebaseAuthWithGoogle(idToken: String) {
//        // [START_EXCLUDE silent]
//        //     showProgressBar()
//        // [END_EXCLUDE]
//        val credential = GoogleAuthProvider.getCredential(idToken, null)
//        auth.signInWithCredential(credential)
//            .addOnCompleteListener(this) { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.i("testing", "signInWithCredential:success")
//                    //     val user = auth.currentUser
//                    //   updateUI(user)
//                } else {
//                    // If sign in fails, display a message to the user.
//                    Log.i("testing", "signInWithCredential:failure", task.exception)
//                    // [START_EXCLUDE]
//                    //    val view = binding.mainLayout
//                    // [END_EXCLUDE]
//                    //      Snackbar.make(view, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
//                    //  updateUI(null)
//                }
//
//                // [START_EXCLUDE]
//                //    hideProgressBar()
//                // [END_EXCLUDE]
//            }
//    }
//}
