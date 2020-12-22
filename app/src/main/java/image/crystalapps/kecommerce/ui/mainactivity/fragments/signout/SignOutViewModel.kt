package image.crystalapps.kecommerce.ui.mainactivity.fragments.signout

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.Account
import image.crystalapps.kecommerce.model.Clothes
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.ui.mainactivity.MainRepository
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignOutViewModel  @ViewModelInject constructor(val mainRepository: MainRepository ,val firebaseAuth: FirebaseAuth ):
    BaseViewModel<SignOutViewModel>(mainRepository) ,FirebaseAuth.AuthStateListener {





    fun isLogin(firebaseAuth: FirebaseAuth){
      val currentUser=  firebaseAuth.currentUser

        if(currentUser!=null){


        }else{


        }

    }





    fun checkUserAvailbility(firebaseAuth :FirebaseAuth):Boolean{
       val user=    firebaseAuth.currentUser
        return user!=null }



    private fun filterData(data : Result<Account>) :LiveData<Account>{
        val result =MutableLiveData<Account>()

        if (data is Result.Success){

            viewModelScope.launch {
                result.value = data.data
            }
        }

        if(data is Result.Error){


        }

        return result
    }

    override fun onAuthStateChanged(p0: FirebaseAuth) {



    }


}