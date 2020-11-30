package image.crystalapps.kecommerce.ui.checkout

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.data.database.prefs.SharedPreferenceEntry
import image.crystalapps.kecommerce.model.Address
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.utils.QueryLiveData
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.launch

class CheckOutViewModel @ViewModelInject constructor(val checkRepository: CheckRepository) : BaseViewModel<CheckOutNavigator>(checkRepository)   {




    val mUpdateEvent = MutableLiveData<Boolean>(false)



    val addressLiveData =mUpdateEvent.switchMap {

        checkRepository.getAddress().distinctUntilChanged().switchMap {
                data->
            filterData(data)

        }}



    private fun filterData(data : Result<Address>) : LiveData<Address> {
        val result = MutableLiveData<Address>()
        if (data is Result.Success){
       //     viewModelScope.launch {
                result.value=data.data

     //       }
        }
        if(data is Result.Error){
            println("Error is cominng") }
        return result }




}
