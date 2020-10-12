package image.crystalapps.ekommerceAdmin.model

import com.google.gson.annotations.SerializedName


class SendNotificationBean(@field:SerializedName("to") var to: String, notification: Notification) {
    @SerializedName("notification")
    private var notification: Notification

    fun getNotification(): Notification {
        return notification
    }

    fun setNotification(notification: Notification) {
        this.notification = notification
    }

    init {
        this.notification = notification
    }
}
