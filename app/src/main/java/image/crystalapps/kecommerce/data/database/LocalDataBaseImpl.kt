package image.crystalapps.kecommerce.data.database

import image.crystalapps.kecommerce.data.database.prefs.SaveTokenSharedPreferenceHelper
import image.crystalapps.kecommerce.data.database.prefs.SharedPreferenceEntry
import javax.inject.Inject

class LocalDataBaseImpl  @Inject constructor(private  val sharedPreferenceHelper: SaveTokenSharedPreferenceHelper) :LocalDataBaseManager {


    override  fun saveInformation(sharedPreferenceEntry: SharedPreferenceEntry) {
        sharedPreferenceHelper.savePersonalInfo(sharedPreferenceEntry) }

    override  fun getPersonalInfo():SharedPreferenceEntry {
        return sharedPreferenceHelper.getTokenInformation()
    }


}