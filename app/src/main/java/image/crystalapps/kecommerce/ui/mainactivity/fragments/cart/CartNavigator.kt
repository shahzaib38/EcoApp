package image.crystalapps.kecommerce.ui.mainactivity.fragments.cart

import image.crystalapps.kecommerce.model.Cart

interface CartNavigator {


  fun checkOut(total :Int ,arrayList :ArrayList<Cart>)

}