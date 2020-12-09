package image.crystalapps.kecommerce.ui.mainactivity

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.google.firebase.auth.FirebaseAuth
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.data.Event
import image.crystalapps.kecommerce.model.NotificationBean
import image.crystalapps.kecommerce.model.UserProfile
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(val mainRepository : MainRepository ):
    BaseViewModel<MainNavigator>(mainRepository) {



    val mUserProfileUpdate = MutableLiveData<UserProfile>()
    val mUpdateEvent = MutableLiveData<Boolean>(false)
    val _userProfile = MutableLiveData<Boolean>(false)


    val username =MutableLiveData<String>("")


    fun submit(){


    }


    fun submitButton(){
        println(username.value)

    }



    fun openProfileDialog(view : View){
        getNavigator().openProfileDialog(view) }


    fun getUserProfile():LiveData<UserProfile> {
  return  mainRepository.getUserProfile("7m5pHZ89AecrwnlLKjuoLlZfpMh1").distinctUntilChanged().switchMap {
        data->
        filterUserProfileData(data)
    }
}

    private fun filterUserProfileData(data: Result<UserProfile>): LiveData<UserProfile> {
        val result =MutableLiveData<UserProfile>()
        if (data is Result.Success){
            println("Success")
            //   viewModelScope.launch {
        val username=    data.data.username

            result.value = data.data }

        return result
    }


    val allProductsLiveData =mUpdateEvent.switchMap {
        mainRepository.getAllProducts().distinctUntilChanged().switchMap {
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

    //LiveData
    val _snackBarText = MutableLiveData<Event<Int>>()
    val snackBarText =_snackBarText


   private val _userName =MutableLiveData<String>()
    val userName =_userName


    fun checkGoogleAuthentication( token :String? ,googleAuthentication :FirebaseAuth?){
       if(googleAuthentication!=null){
           val mCurrentUser=     googleAuthentication.currentUser

           if (mCurrentUser!=null) {
           //    _userProfile.value = mCurrentUser
               _snackBarText.value = Event(R.string.successfull_login)
                   mainRepository.registerInstanceIdManager(token)

           }
       } else{
           _snackBarText.value=Event(R.string.google_LogIn)

       }

    }




















  fun  insert(notification :NotificationBean)
  {
      viewModelScope.launch(Dispatchers.IO) {
          mainRepository.insert(notification)
      }
  }



}