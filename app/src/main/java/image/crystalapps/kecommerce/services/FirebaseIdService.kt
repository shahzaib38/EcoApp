package image.crystalapps.kecommerce.services

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.media.RingtoneManager
import android.net.Uri
import android.os.Build
import android.util.Log
import androidx.core.app.NotificationCompat
import androidx.work.Data
import androidx.work.OneTimeWorkRequest
import androidx.work.WorkManager
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import image.crystala.MainActivity
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.data.ClientApplication
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.data.database.prefs.SharedPreferenceEntry
import image.crystalapps.kecommerce.model.NotificationBean
import image.crystalapps.kecommerce.workers.NotificationWorkManager

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

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)




        // Check if message contains a notification payload.
        remoteMessage.notification?.let {
                
            Firebase.firestore.collection("users").document("7m5pHZ89AecrwnlLKjuoLlZfpMh1")
                .collection("notifications")
                .add(NotificationBean(it.title,it.body,"https://firebasestorage.googleapis.com/v0/b/delicious-food-21577.appspot.com/o/jackets.jpg?alt=media&token=0fcbe68f-9444-4315-ae8a-b36397409604"))
    
    

        }




    }


//    private fun sendNotification(messageBody: String) {
//        val intent = Intent(this, MainActivity::class.java)
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
//        val pendingIntent = PendingIntent.getActivity(this, 0 /* Request code */, intent,
//            PendingIntent.FLAG_ONE_SHOT)
//
//        val channelId = getString(R.string.default_notification_channel_id)
//        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
//        val notificationBuilder = NotificationCompat.Builder(this, channelId)
//            .setSmallIcon(R.drawable.ic_launcher_foreground)
//            .setContentTitle("Fcm Message")
//            .setContentText(messageBody)
//            .setAutoCancel(true)
//            .setSound(defaultSoundUri)
//            .setContentIntent(pendingIntent)
//
//        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
//
//        // Since android Oreo notification channel is needed.
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            val channel = NotificationChannel(channelId,
//                "Channel human readable title",
//                NotificationManager.IMPORTANCE_DEFAULT)
//            notificationManager.createNotificationChannel(channel)
//        }
//
//        notificationManager.notify(0 /* ID of notification */, notificationBuilder.build())
//    }

    //

    private fun sendUpdateNotification(title: String?, messageBody: String?) {
        val intent = Intent(Intent.ACTION_VIEW)
       // intent.data = Uri.parse(NotificationServiceUtils.URL)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 0)
        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val channelId = getString(R.string.default_notification_channel_id)
        val defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION)
        val notificationBuilder = NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.notification_icon)
            .setContentTitle(title)
            .setContentText(messageBody)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .setSound(defaultSoundUri).setStyle(NotificationCompat.BigTextStyle()
                .bigText(messageBody))
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(channelId, title, NotificationManager.IMPORTANCE_DEFAULT)
            channel.description = messageBody
            notificationManager.createNotificationChannel(channel)
        }
        notificationManager.notify(0, notificationBuilder.build())
    }






    private  fun createSharedPreferenceEntry(newToken :String){

        if (newToken.isNotEmpty()) {
            println(newToken)
        val sharedPreferenceEntry=    SharedPreferenceEntry(newToken)
                   dataManager.saveTokenInformation(sharedPreferenceEntry) }
  }




}