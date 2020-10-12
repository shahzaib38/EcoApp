package image.crystalapps.kecommerce.model

import android.os.Parcel
import android.os.Parcelable
import android.util.Size
import image.crystalapps.kecommerce.utils.Model

data class ProductsDetails(val name: String? = null, val arrayList: ArrayList<Sizes>? = null) :
    Model(), Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.createTypedArrayList(Sizes.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(name)
        writeTypedList(arrayList)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<ProductsDetails> =
            object : Parcelable.Creator<ProductsDetails> {
                override fun createFromParcel(source: Parcel): ProductsDetails =
                    ProductsDetails(source)

                override fun newArray(size: Int): Array<ProductsDetails?> = arrayOfNulls(size)
            }
    }
}