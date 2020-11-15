package image.crystalapps.kecommerce.extensions

import android.widget.TextView
import androidx.databinding.BindingAdapter
import image.crystalapps.kecommerce.model.Cart
import java.math.BigDecimal





fun Iterable<BigDecimal>.sum(): BigDecimal {
    var sum: BigDecimal = BigDecimal.ZERO
    for (element in this) {
        sum += element
    }
    return sum
}


fun Iterable<Cart>.multiple(): BigDecimal {
    val value= this.map {
        it.qty.toBigDecimal() * it.products!!.productPrice!!.toBigDecimal()
    }.sum()

    return value
}


fun Int.sum():String{
    return if(this >1){
        "Items: $this"
    }else{
        "Item: $this"
    }
}