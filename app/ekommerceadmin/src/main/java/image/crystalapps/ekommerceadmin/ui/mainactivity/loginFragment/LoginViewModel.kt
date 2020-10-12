package image.crystalapps.ekommerceadmin.ui.mainactivity.loginFragment

import  android.util.Log
import javax.inject.Inject


class LoginViewModel @Inject constructor( dataManager : DataManager) : BaseViewModel(dataManager) {


   // fun checkGoogleSignIn(googleSignInAccount: GoogleSignInAccount) {
//
//        getCompositeDisposable().add(dataManager.checkGoogleSignIn(googleSignInAccount).
//            subscribeOn(getSchedularProviders().io())
//            .observeOn(getSchedularProviders().newThread())
//            .subscribe {
//               it.addOnSuccessListener {
//
//
//                   Log.i("test","Test Successfull ${it.user}")
//
//
//               }.addOnFailureListener{
//                   Log.i("test","Test Failed $it")
//
//
//               }
//
//
//            })
//
//
//

   // }


}