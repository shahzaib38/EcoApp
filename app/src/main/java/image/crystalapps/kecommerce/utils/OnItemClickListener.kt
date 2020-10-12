package image.crystalapps.kecommerce.utils

import android.view.View

interface OnItemClickListener<T> {
    fun clickItem(view : View, item :T)

}