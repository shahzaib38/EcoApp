package image.crystalapps.kecommerce.data.database.prefs

import android.content.SharedPreferences
import javax.inject.Inject

class SaveTokenSharedPreferenceHelper @Inject constructor(val sharedPreferences: SharedPreferences) {

    companion object{
      private const val Token_Key ="token_key" }

     fun savePersonalInfo(sharedPreferenceEntry: SharedPreferenceEntry) :Boolean{
        val sharedPreferenceEditor :SharedPreferences.Editor =sharedPreferences.edit()
        sharedPreferenceEditor.putString(Token_Key ,sharedPreferenceEntry.token)
        return sharedPreferenceEditor.commit() }

    fun getTokenInformation() :SharedPreferenceEntry{
      val token=  sharedPreferences.getString(Token_Key ,"")

        return SharedPreferenceEntry(token)
    }



}