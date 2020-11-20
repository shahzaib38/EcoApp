package image.crystalapps.kecommerce.ui.address

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.Address
import image.crystalapps.kecommerce.ui.base.BaseViewModel


class AddressViewModel @ViewModelInject constructor(val  dataManager: DataManager) :BaseViewModel<AddressNavigator>(dataManager) {

    //User Name LiveData
    val _FullNameLiveData =MutableLiveData<String>("")
    val fullNameLiveData =_FullNameLiveData

    // Mobile Number LiveData
    val _MobileNumber =MutableLiveData<String>("")
    val mobileNumber =_MobileNumber

    // Provide LiveData
    val _ProvinceLiveData =MutableLiveData<String>("")
    val provinceLiveData =_ProvinceLiveData

    //City LiveData
    val _CityLiveData =MutableLiveData<String>("")
    val cityLiveData =_CityLiveData

    //Area LiveData
    val _AreaLiveData=MutableLiveData<String>("")
    val areaLiveData =_AreaLiveData

    //Address LiveData
    val _AddressLiveData =MutableLiveData<String>("")
    val addressLiveData =_AddressLiveData





    fun save(){


val address =        Address(addressLiveData.value ,provinceLiveData.value ,cityLiveData.value,areaLiveData.value ,mobileNumber.value ,fullNameLiveData.value)



    }



}