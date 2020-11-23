package image.crystalapps.kecommerce.model

import android.os.Parcel
import android.os.Parcelable
import java.util.*

data class NotificationBean(
    var title: String? = null,
    var description: String? = null,
    var imageUrl: String? = null
) : Model(), Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(title)
        writeString(description)
        writeString(imageUrl)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<NotificationBean> =
            object : Parcelable.Creator<NotificationBean> {
                override fun createFromParcel(source: Parcel): NotificationBean =
                    NotificationBean(source)

                override fun newArray(size: Int): Array<NotificationBean?> = arrayOfNulls(size)
            }
    }
}