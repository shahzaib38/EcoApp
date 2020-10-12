package image.crystalapps


import android.os.Parcel
import android.os.Parcelable
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.utils.Model

data class Products(
    val productName: String? = null,
    val productId: String? = null,
    val productImage: String? = null,
    val priceDescription: String? = null,
    val productPrice: String? = null,
    val productsDetails: List<ProductsDetails>? = null
) : Model(), Parcelable {
    constructor() : this("", "", "", "", "", null)

    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.createTypedArrayList(ProductsDetails.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(productName)
        writeString(productId)
        writeString(productImage)
        writeString(priceDescription)
        writeString(productPrice)
        writeTypedList(productsDetails)
    }

    companion object {
        @JvmField
        val CREATOR: Parcelable.Creator<Products> = object : Parcelable.Creator<Products> {
            override fun createFromParcel(source: Parcel): Products = Products(source)
            override fun newArray(size: Int): Array<Products?> = arrayOfNulls(size)
        }
    }
}