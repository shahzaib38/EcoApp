package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.data.Event
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.ui.mainactivity.MainRepository
import javax.inject.Inject

class LogInViewModel @ViewModelInject constructor(val mainRepository : MainRepository) :
    BaseViewModel<LogInNavigator>(mainRepository) {

    //LiveData
    val _snackBarText = MutableLiveData<Event<Int>>()
    val snackBarText =_snackBarText

    val _progressBar =MutableLiveData<Boolean>(false)
    val progressBar =_progressBar


   private val _dataLoading =MutableLiveData<Boolean>()
    val dataLoading =_dataLoading



  fun  signOut(){

      getNavigator().signOut()
  }


     fun showSnackBar(message :Int){
        _snackBarText.value= Event(message)}

    fun setProgressBarVisibility(boolean: Boolean){
        _progressBar.value=boolean }


    fun close(){
        getNavigator().dismissDialog()
    }

    fun signIn(){

        getNavigator().signIn()
    }

    fun googleAuth(firebaseAuth :FirebaseAuth?){
        getNavigator().setGoogleAuth(firebaseAuth)

    }




}