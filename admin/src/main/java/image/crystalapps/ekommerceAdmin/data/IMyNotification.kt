package image.crystalapps.ekommerceAdmin.data

import image.crystalapps.ekommerceAdmin.Utils.NotificationUtils.NotificationUtils.KEY
import image.crystalapps.ekommerceAdmin.model.SendNotificationBean
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface IMyNotification {
    @Headers("Content-Type:application/json", "Authorization:$KEY")
    @POST("send")
    suspend fun listRepos(@Body notification: SendNotificationBean?): Call<SendNotificationBean?>?
}
