package image.crystalapps.kecommerce.model

import android.os.Parcel
import android.os.Parcelable


data class Products(
    var productType: String? = null,
    var categoryName: String? = null,
    var productName: String? = null,
    var numRating: String? = null,
    var inStock: Int = 0,
    var avgRating: String? = null,
    var productId: String? = null,
    var productImage: List<String>? = null,
    var priceDescription: String? = null,
    var productPrice: Int = 0,
    var productsDetails: List<ProductsDetails>? = null
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