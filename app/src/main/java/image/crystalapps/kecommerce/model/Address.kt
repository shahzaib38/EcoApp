package image.crystalapps.kecommerce.model

import android.os.Parcel
import android.os.Parcelable

data class Address(
    val address: String?,
    val province: String?, val city: String?, val area: String? = ""
    , val mobileNumber: String?, val fullName: String?
):Model(),  Parcelable {

    constructor():this("","","","","","")
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()!!,
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(address)
        writeString(province)
        writeString(city)
        writeString(area)
        writeString(mobileNumber)
        writeString(fullName)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Address> = object : Parcelable.Creator<Address> {
            override fun createFromParcel(source: Parcel): Address = Address(source)
            override fun newArray(size: Int): Array<Address?> = arrayOfNulls(size)
        }
    }

}