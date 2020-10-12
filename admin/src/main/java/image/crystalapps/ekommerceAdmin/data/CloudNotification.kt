package image.crystalapps.ekommerceAdmin.data

import android.content.Context
import android.util.Log
import image.crystalapps.ekommerceAdmin.Utils.NotificationUtils.NotificationUtils.TO
import image.crystalapps.ekommerceAdmin.model.Notification
import image.crystalapps.ekommerceAdmin.model.SendNotificationBean
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class CloudNotification(
    private val iNotification: IMyNotification?,
    private val context: Context
) : ICloudNotification {







   override suspend fun sendNotification(title: String, description: String) {
       if (iNotification != null) {
            val notification = Notification(title!!, description!!)
            val sendNotification = SendNotificationBean(TO, notification)
            val sendNotificationBeanCall: Call<SendNotificationBean?>? =
                iNotification.listRepos(sendNotification)
            sendNotificationBeanCall!!.enqueue(object : Callback<SendNotificationBean?> {
                override fun onResponse(
                    call: Call<SendNotificationBean?>,
                    response: Response<SendNotificationBean?>
                ) {
                    if (response.isSuccessful()) {

                    } else { }
                }
                override fun onFailure(
                    call: Call<SendNotificationBean?>,
                    t: Throwable
                ) {

                    print(t.message)
                }
            })
        }
    }



}
