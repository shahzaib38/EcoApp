package image.crystalapps.kecommerce.model

import android.os.Parcel
import android.os.Parcelable

data class Sizes(var text: String? = null, var imageUrl: String? = null) : Model(), Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(text)
        writeString(imageUrl)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Sizes> = object : Parcelable.Creator<Sizes> {
            override fun createFromParcel(source: Parcel): Sizes = Sizes(source)
            override fun newArray(size: Int): Array<Sizes?> = arrayOfNulls(size)
        }
    }
}