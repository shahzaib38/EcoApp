package image.crystalapps.kecommerce.model

import android.os.Parcel
import android.os.Parcelable

data class CartCheckOut(val arrayList: ArrayList<Cart>? = null, val totalItem: String? = null) :
    Model(), Parcelable {
    constructor(source: Parcel) : this(
        source.createTypedArrayList(Cart.CREATOR),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeTypedList(arrayList)
        writeString(totalItem)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<CartCheckOut> = object : Parcelable.Creator<CartCheckOut> {
            override fun createFromParcel(source: Parcel): CartCheckOut = CartCheckOut(source)
            override fun newArray(size: Int): Array<CartCheckOut?> = arrayOfNulls(size)
        }
    }
}