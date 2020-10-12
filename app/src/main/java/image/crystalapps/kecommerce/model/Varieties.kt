package image.crystalapps.kecommerce.model

import android.os.Parcel
import android.os.Parcelable

open class Varieties(val varity: String? = null, val sizes: String? = null) : BaseItem(),
    Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(varity)
        writeString(sizes)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Varieties> = object : Parcelable.Creator<Varieties> {
            override fun createFromParcel(source: Parcel): Varieties = Varieties(source)
            override fun newArray(size: Int): Array<Varieties?> = arrayOfNulls(size)
        }
    }
}