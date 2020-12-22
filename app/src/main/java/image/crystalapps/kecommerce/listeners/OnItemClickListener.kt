package image.crystalapps.kecommerce.listeners

import android.view.View

interface OnItemClickListener<T> {
    fun clickItem(view : View, item :T)

}