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


   private val _dataLoading =MutableLiveData<Boolean>()
    val dataLoading =_dataLoading





    private fun showSnackBar(message :Int){
        _snackBarText.value= Event(message)}

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