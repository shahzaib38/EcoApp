package image.crystalapps.kecommerce.ui.productselection.dialogfragment

import image.crystalapps.kecommerce.model.Model

data class RatingItem(val rating :Int?=0 ,var isSelected :Boolean=false) :
    Model()