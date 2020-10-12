package image.crystalapps.kecommerce.data.database

import image.crystalapps.kecommerce.data.database.prefs.SharedPreferenceEntry

interface LocalDataBaseManager {


    fun  saveInformation(sharedPreferenceEntry :SharedPreferenceEntry)

     fun getPersonalInfo():SharedPreferenceEntry

}