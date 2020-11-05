package image.crystalapps.kecommerce.utils

import androidx.lifecycle.LiveData
import com.google.firebase.firestore.*
import com.google.firebase.firestore.auth.User
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.model.UserProfile


class ProductLiveData<Data>(private val ref :DocumentReference , private val type :Class<Data>) :LiveData<Result<Data>>() ,EventListener<DocumentSnapshot>{

    private var registration: ListenerRegistration?=null

    override fun onActive() {
        super.onActive()
        println("OnActive")
        registration=  ref.addSnapshotListener(this)

    }


    override fun onInactive() {
        super.onInactive()
        println("OnInActive")
        registration?.run {
            remove()
            null }

    }

    override fun onEvent(documentSnapShot : DocumentSnapshot?, error: FirebaseFirestoreException?) {
        if (error!=null){
            println("Error $error.message")
            value = Result.Error(error)
            return }
        if (documentSnapShot!=null) {
         val document=   documentSnapShot.toObject(type)
            if (document!=null){
                value=Result.Success(document)

            }

        }
    }





}