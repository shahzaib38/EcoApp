package image.crystalapps.kecommerce.customview

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import androidx.constraintlayout.widget.ConstraintLayout
import image.crystalapps.kecommerce.R

class PriceView(context : Context ,attributeSet: AttributeSet?=null) :ConstraintLayout(context ,attributeSet) {




    init
    {
        View.inflate(context , R.layout.priceview ,this)
        setBackgroundColor(resources.getColor(R.color.colorPrimary,null))
        layoutParams =LayoutParams(MATCH_PARENT , MATCH_PARENT)


    }








}