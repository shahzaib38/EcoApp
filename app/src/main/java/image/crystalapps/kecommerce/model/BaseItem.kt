package image.crystalapps.kecommerce.model

import android.os.Parcel
import android.os.Parcelable

open class BaseItem() : Model(), Parcelable {
    constructor(source: Parcel) : this(
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {}

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<BaseItem> = object : Parcelable.Creator<BaseItem> {
            override fun createFromParcel(source: Parcel): BaseItem = BaseItem(source)
            override fun newArray(size: Int): Array<BaseItem?> = arrayOfNulls(size)
        }
    }
}