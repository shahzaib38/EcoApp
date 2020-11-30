package image.crystalapps.kecommerce.utils

import android.provider.Telephony
import image.crystalapps.kecommerce.model.Address

object FieldValidator {

    fun isNameValid(value: String?) :Boolean =!value.isNullOrEmpty()

    fun isPhoneNumberValid(number :String?) :Boolean = !number.isNullOrEmpty() && number.length>=8


//
//    fun isProvinceIsEmpty() :Boolean  = province.isNullOrEmpty()
//    fun isCityIsEmpty() :Boolean  = city.isNullOrEmpty()
//    fun isAddressIsEmpty() :Boolean  = address.isNullOrEmpty()

    fun checkAddressIsNullOrEmpty(address: Address) :Boolean {
        return with(address) {
            !province.isNullOrEmpty() && !city.isNullOrEmpty() && !this.address.isNullOrEmpty() } }




}