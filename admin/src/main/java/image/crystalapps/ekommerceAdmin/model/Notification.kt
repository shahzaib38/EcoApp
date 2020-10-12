package image.crystalapps.ekommerceAdmin.model

import com.google.gson.annotations.SerializedName


public class Notification(
    @field:SerializedName("title") var title: String, @field:SerializedName(
        "body"
    ) var body: String
)
