package image.crystalapps.kecommerce.data.network.firebase

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.functions.FirebaseFunctions
import com.google.firebase.ktx.Firebase
import image.crystalapps.kecommerce.model.Address
import image.crystalapps.kecommerce.model.NotificationBean
import javax.inject.Singleton

@Singleton
class ServerFunctionsImpl :ServerFunctions {



    override fun registerInstanceId(instanceId: String) {
         val firebaseFunctions = FirebaseFunctions.getInstance()

        firebaseFunctions
            .getHttpsCallable("instanceId_register")
            .call(null)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    println("Success")
                } else {

                        println("Error ${task.exception}")

                }
            }
    }

    override fun sendNotification(notification: NotificationBean) {
        val firebaseFunctions = FirebaseFunctions.getInstance()

        firebaseFunctions
            .getHttpsCallable("notification_register")
            .call(notification)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    println("Success")
                } else {
                    println("Error ${task.exception}")
                }
            }
    }


    override fun save(address: Address) {

      val hashMap =  HashMap<String ,Address>()
        hashMap.put("address" ,address)
        Firebase.firestore.collection("users").document("7m5pHZ89AecrwnlLKjuoLlZfpMh1")
            .set(hashMap)

    }


}