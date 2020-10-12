package image.crystalapps.kecommerce.ui.mainactivity

import androidx.lifecycle.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import image.crystalapps.Products
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.data.Event
import image.crystalapps.kecommerce.utils.Result
import javax.inject.Inject
import kotlinx.coroutines.launch

class MainViewModel @Inject constructor(val dataManager: DataManager ):
    BaseViewModel<MainNavigator>(dataManager) {



 //   val product =Transformations.switchMap(  allProductsLiveData,dataManager.getAllProducts().value)


    val mUpdateEvent =MutableLiveData<Boolean>(false)

    val allProductsLiveData =mUpdateEvent.switchMap {
       dataManager.getAllProducts().distinctUntilChanged().switchMap {
         filterData(it)
     }

    }


   private fun filterData(data : Result<List<Products>>) : LiveData<List<Products>> {
        val result =MutableLiveData< List<Products>>()

    //    if (data==null){
    //        println("data is null")

   //     }


    //   result.postValue(data.data)
   //    data?.run {


           if (data is Result.Success) {
               println("Success")
            //   viewModelScope.launch {
                   result.value = data.data
               }
   //        }
//
//           if (data is Result.Error) {
//               println("Error is cominng")
//           }

  //     }
        return result
    }

    fun setValue(value :String){
        viewModelScope.launch {
            println(Thread.currentThread().name) } }

   //UserProfile LiveData
     val _userProfile =MutableLiveData<FirebaseUser>()
    val userProfile=_userProfile

    //LiveData
    val _snackBarText = MutableLiveData<Event<Int>>()
    val snackBarText =_snackBarText


   private val _userName =MutableLiveData<String>()
    val userName =_userName


    fun checkGoogleAuthentication( token :String? ,googleAuthentication :FirebaseAuth?){
       if(googleAuthentication!=null){
           val mCurrentUser=     googleAuthentication.currentUser

           if (mCurrentUser!=null) {
               _userProfile.value = mCurrentUser
               _snackBarText.value = Event(R.string.successfull_login)
                   dataManager.registerInstanceIdManager(token)

           }
       } else{
           _snackBarText.value=Event(R.string.google_LogIn)

       }

    }



}