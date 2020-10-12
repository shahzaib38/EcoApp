package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments

import com.google.firebase.auth.FirebaseAuth

interface LogInNavigator {


    fun signIn()

    fun dismissDialog()
   fun  setGoogleAuth(firebaseAuth: FirebaseAuth?)
}