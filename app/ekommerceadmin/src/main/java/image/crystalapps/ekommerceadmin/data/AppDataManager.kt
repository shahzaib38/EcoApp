package image.crystalapps.ekommerceadmin.data

import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import io.reactivex.Observable
import javax.inject.Inject

class AppDataManager @Inject constructor() : DataManager {


    private fun firebaseAuthWithGoogle(idToken: String): Task<AuthResult> {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
      return  Firebase.auth.signInWithCredential(credential)

//            .addOnCompleteListener { task ->
//                if (task.isSuccessful) {
//                    // Sign in success, update UI with the signed-in user's information
//                    Log.i("test", "signInWithCredential:success")
//                  //  val user = auth.currentUser
//                //    updateUI(user)
//
//
//                } else {
//                    // If sign in fails, display a message to the user.
//                 //   Log.w(TAG, "signInWithCredential:failure", task.exception)
//                    // ...
//             //       Snackbar.make(view, "Authentication Failed.", Snackbar.LENGTH_SHORT).show()
//               //     updateUI(null)
//                }
//
//                // ...
//
//
//            }
    }

}