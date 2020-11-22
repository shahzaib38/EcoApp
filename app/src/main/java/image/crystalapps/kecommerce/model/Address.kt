package image.crystalapps.kecommerce.model

import android.os.Parcel
import android.os.Parcelable

class Address(
    var address: String? = null,
    var province: String? = null, var city: String? = null, var state: String? = null
    , var mobileNumber: String? = null, var fullName: String? = null
) : Model(), Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(address)
        writeString(province)
        writeString(city)
        writeString(state)
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