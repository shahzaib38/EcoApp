package image.crystalapps.kecommerce.ui.mainactivity.fragments.profile

import android.view.View
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.distinctUntilChanged
import androidx.lifecycle.switchMap
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.UserProfile
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.ui.mainactivity.MainRepository
import image.crystalapps.kecommerce.utils.Result


class ProfileViewModel  @ViewModelInject constructor(val mainRepository: MainRepository) :BaseViewModel<ProfileNavigator>(mainRepository) {


    fun openProfileDialog(view: View ){
        getNavigator().openProfileDialog(view)
         }















    fun getUserProfile(): LiveData<UserProfile> {
        return  mainRepository.getUserProfile("7m5pHZ89AecrwnlLKjuoLlZfpMh1").distinctUntilChanged().switchMap {
                data->
            filterUserProfileData(data)
        }
    }

    private fun filterUserProfileData(data: Result<UserProfile>): LiveData<UserProfile> {
        val result = MutableLiveData<UserProfile>()
        if (data is Result.Success){
            println("Success")
            //   viewModelScope.launch {
            val username=    data.data.username

            result.value = data.data }

        return result
    }



}