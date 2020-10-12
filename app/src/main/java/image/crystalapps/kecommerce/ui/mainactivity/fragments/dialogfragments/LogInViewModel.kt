package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments

import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.data.Event
import javax.inject.Inject

class LogInViewModel @Inject constructor(val dataManager: DataManager) :BaseViewModel<LogInNavigator>(dataManager) {

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


        println(  getGoogleCurrentUser()?.uid)


  //      dataManager.registerInstanceIdManager("shahzaib baloch lashari")

    }

    fun googleAuth(firebaseAuth :FirebaseAuth?){





        getNavigator().setGoogleAuth(firebaseAuth)

    }




}