package image.crystalapps.kecommerce.model

import android.os.Parcel
import android.os.Parcelable


data class Products(
    val productType: String? = null,
    val categoryName: String? = null,
    val productName: String? = null,
    val numRating: String? = null,
    val inStock: Int = 0,
    var avgRating: String? = null,
    val productId: String? = null,
    val productImage: List<String>? = null,
    val priceDescription: String? = null,
    val productPrice: Int = 0,
    val productsDetails: List<ProductsDetails>? = null
) : Model(), Parcelable {
    constructor(source: Parcel) : this(
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readInt(),
        source.readString(),
        source.readString(),
        source.createStringArrayList(),
        source.readString(),
        source.readInt(),
        source.createTypedArrayList(ProductsDetails.CREATOR)
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeString(productType)
        writeString(categoryName)
        writeString(productName)
        writeString(numRating)
        writeInt(inStock)
        writeString(avgRating)
        writeString(productId)
        writeStringList(productImage)
        writeString(priceDescription)
        writeInt(productPrice)
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