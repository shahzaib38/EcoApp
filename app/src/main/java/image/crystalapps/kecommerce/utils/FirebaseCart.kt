package image.crystalapps.kecommerce.utils

import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import image.crystalapps.Products

object FirebaseCart {
    fun addToCart(product:Products){
        Firebase.firestore.collection("users").document("7m5pHZ89AecrwnlLKjuoLlZfpMh1")
            .collection("Cart").document().set(product) }
}