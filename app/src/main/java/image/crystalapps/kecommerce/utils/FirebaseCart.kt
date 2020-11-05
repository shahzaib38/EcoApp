package image.crystalapps.kecommerce.utils

import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import image.crystalapps.kecommerce.model.Cart

object FirebaseCart {


    fun addToCart(product: Cart){
        val doc=  Firebase.firestore.collection("users").document("7m5pHZ89AecrwnlLKjuoLlZfpMh1").collection("Cart").document(product.products?.productId!!)
        doc.get().addOnCompleteListener {
            val result =   it.result
            if (result!=null){
                if(result.exists()){
                    doc.update("qty",FieldValue.increment(1)) }
                else { doc.set(product) }
            }

        }

    }


    fun decrement(product: Cart){
        val doc=  Firebase.firestore.collection("users").document("7m5pHZ89AecrwnlLKjuoLlZfpMh1").collection("Cart").document(product.products?.productId!!)
        doc.get().addOnCompleteListener {
            val result =   it.result
            if (result!=null){
                if(result.exists()){
                    doc.update("qty",FieldValue.increment(-1))
                }else{
                    doc.set(product)
                }
            }

        }

    }


}