package image.crystalapps.kecommerce.databinding

import android.view.View
import androidx.databinding.BindingAdapter
import image.crystalapps.kecommerce.model.Address
import kotlinx.android.synthetic.main.checkout_layout.view.*
import kotlinx.android.synthetic.main.shipping_address_layout.view.*


@BindingAdapter("addressContent")
fun View.addressContent(address: Address?){
  val textView = this.shippingaddress.textView10
  val addButton = this.shippingaddress.add_address
    val fullName =this.shippingaddress.editText3
    val email =this.shippingaddress.editText4
    val username=this.shippingaddress.user_name

         if(address!=null){
             email.setText("engineer.shahzaib38@gmail.com")

             if (address.address != null) {
            textView.visibility = View.VISIBLE
            fullName.visibility = View.VISIBLE
             username.visibility= View.VISIBLE
            textView.text = address.address
            fullName.text=address.mobileNumber
                 username.text =address.fullName


        } else {
            addButton.visibility = View.VISIBLE
            fullName.visibility = View.GONE

        }

    }else{


    }

}