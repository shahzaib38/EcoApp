package image.crystalapps.kecommerce.model

import android.R
import android.text.TextUtils
import com.google.firebase.firestore.Query


class Filter {
    var category: String? = null
    var city: String? = null
    var price = -1
    var sortBy: String? = null
    var sortDirection: Query.Direction? = null

    fun hasCategory(): Boolean {
        return !TextUtils.isEmpty(category)
    }

    fun hasCity(): Boolean {
        return !TextUtils.isEmpty(city)
    }

    fun hasPrice(): Boolean {
        return price > 0
    }

    fun hasSortBy(): Boolean {
        return true
    }


    companion object {
        val default: Filter
            get() {
                val filters = Filter()
                filters.sortBy = "productPrice"
                filters.sortDirection = Query.Direction.DESCENDING
                return filters
            }
    }
}