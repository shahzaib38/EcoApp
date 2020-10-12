package image.crystalapps.kecommerce.services

import com.google.firebase.messaging.FirebaseMessagingService
import image.crystalapps.kecommerce.data.ClientApplication
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.data.database.prefs.SharedPreferenceEntry

class FirebaseIdService : FirebaseMessagingService() {

    lateinit var dataManager: DataManager

    override fun onCreate() {
        super.onCreate()
        dataManager = (application as ClientApplication).dataManager }


    override fun onNewToken(newToken: String) {
        super.onNewToken(newToken)
        sendRegistrationTokenToServer(newToken)
        saveRegistrationTokenToLocalDataBase(newToken) }

    private  fun sendRegistrationTokenToServer(newToken :String){
        dataManager.registerInstanceIdManager(newToken) }


    private   fun saveRegistrationTokenToLocalDataBase(newToken: String){
        createSharedPreferenceEntry(newToken)

    }

  private  fun createSharedPreferenceEntry(newToken :String){

        if (newToken.isNotEmpty()) {
            println(newToken)
        val sharedPreferenceEntry=    SharedPreferenceEntry(newToken)
                   dataManager.saveTokenInformation(sharedPreferenceEntry) }
  }

}