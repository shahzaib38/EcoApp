package image.crystalapps.kecommerce.model

import android.net.Uri

data class Categories(val name :String ,val uri : Uri?=null) :
    Model()