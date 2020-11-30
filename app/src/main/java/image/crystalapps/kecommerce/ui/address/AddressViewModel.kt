package image.crystalapps.kecommerce.ui.address

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import image.crystalapps.kecommerce.Event
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.model.Address
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.utils.FieldValidator


class AddressViewModel @ViewModelInject constructor(val  addressRepository: AddressRepository) :BaseViewModel<AddressNavigator>(addressRepository) {

    //User Name LiveData
   private val _FullNameLiveData =MutableLiveData<String>()
    val fullNameLiveData =_FullNameLiveData

    // Mobile Number LiveData
  private  val _MobileNumber =MutableLiveData<String>()
    val mobileNumber =_MobileNumber

    // Provide LiveData
   private  val _ProvinceLiveData =MutableLiveData<String>("")
    val provinceLiveData =_ProvinceLiveData

    //City LiveData
    private val _CityLiveData =MutableLiveData<String>("")
    val cityLiveData =_CityLiveData

    //Area LiveData
    private val _AreaLiveData=MutableLiveData<String>("")
    val areaLiveData =_AreaLiveData

    //Address LiveData
   private  val _AddressLiveData =MutableLiveData<String>("")
    val addressLiveData =_AddressLiveData



    private val _SnackLiveData =MutableLiveData<Event<Int>>()
    val snackBarLiveData =_SnackLiveData

    fun save(){

        val  fullName=  FieldValidator.isNameValid(fullNameLiveData.value)
        val phoneNumber =FieldValidator.isPhoneNumberValid(mobileNumber.value)

        val province =provinceLiveData.value
        val city = cityLiveData.value
        val area =areaLiveData.value
        val address =addressLiveData.value



        if(!fullName){

            _SnackLiveData.value =Event(R.string.fullyQualifeddName)
            return}

        if(!phoneNumber){
            _SnackLiveData.value =Event(R.string.validphone)
            return}


        val userAddress = Address(address , province , city, area ,mobileNumber.value , fullNameLiveData.value)
        if(!FieldValidator.checkAddressIsNullOrEmpty(userAddress))
        {
            _SnackLiveData.value =Event(R.string.full_address)
                  return }

        createAddress(userAddress)

    }

  private  fun createAddress(address :Address){addressRepository.save(address)}









}