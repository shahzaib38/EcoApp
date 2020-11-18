package image.crystalapps.kecommerce.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.constraintlayout.widget.ConstraintLayout
import image.crystalapps.kecommerce.R

class ShippingAddressView(context :Context ,attributeSet: AttributeSet) :ConstraintLayout(context ,attributeSet) {


    init {

        View.inflate(context , R.layout.shipping_address_layout ,this)

        setBackgroundColor(resources.getColor(R.color.white ,null))


    }



}