package image.crystalapps.kecommerce.utils

import com.google.firebase.firestore.IgnoreExtraProperties


@IgnoreExtraProperties
data class Restaurant(    var name: String? = null,
                          var city: String? = null,
                          var category: String? = null,
                          var photo: String? = null,
                          var price: Int = 0,
                          var numRatings: Int = 0,
                          var avgRating: Double = 0.toDouble()
) :Model() {

    companion object {
        const val FIELD_CITY = "city"
        const val FIELD_CATEGORY = "category"
        const val FIELD_PRICE = "price"
        const val FIELD_POPULARITY = "numRatings"
        const val FIELD_AVG_RATING = "avgRating"
    }

}