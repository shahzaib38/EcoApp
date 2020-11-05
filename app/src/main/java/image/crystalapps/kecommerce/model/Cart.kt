package image.crystalapps.kecommerce.model


import android.os.Parcel
import android.os.Parcelable

data class Cart(var qty: Int = 1, var products: Products? = null) : Model(), Parcelable {
    constructor(source: Parcel) : this(
        source.readInt(),
        source.readParcelable<Products>(Products::class.java.classLoader)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeInt(qty)
        writeParcelable(products, 0)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Cart> = object : Parcelable.Creator<Cart> {
            override fun createFromParcel(source: Parcel): Cart = Cart(source)
            override fun newArray(size: Int): Array<Cart?> = arrayOfNulls(size)
        }
    }
}