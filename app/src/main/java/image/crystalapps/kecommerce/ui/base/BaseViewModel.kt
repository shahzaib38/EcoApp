package image.crystalapps.kecommerce.ui.base

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import image.crystalapps.kecommerce.data.DataManager
import kotlinx.coroutines.cancel
import java.lang.ref.WeakReference

abstract class BaseViewModel<N>  constructor(val baseDataManager : BaseRepository) :  ViewModel(){



    lateinit var  mNavigator  : WeakReference<N>
     private val mGoogleAuth : FirebaseAuth=Firebase.auth






   open fun  getGoogleAuth() : FirebaseAuth {
        return mGoogleAuth }

   open fun getGoogleCurrentUser() : FirebaseUser?{
        if (mGoogleAuth!=null){
            return mGoogleAuth.currentUser }
        return null }


    override fun onCleared() {
        viewModelScope.coroutineContext.cancel()
        super.onCleared()}




     fun setNavigator(mNavigator :N){
         this.mNavigator = WeakReference<N>(mNavigator)
     }

   open fun getNavigator() :N{

        return mNavigator.get()!!
    }


    public fun navigate(context : Context? ,activityClass: Class<out Activity>?){

        context?.startActivity(Intent(context, activityClass))


    }

}