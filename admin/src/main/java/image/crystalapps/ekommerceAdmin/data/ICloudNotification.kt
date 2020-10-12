package image.crystalapps.ekommerceAdmin.data

interface ICloudNotification {
    suspend fun sendNotification(title: String, body: String)
}
