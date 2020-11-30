package image.crystalapps.kecommerce.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.bumptech.glide.load.model.Model
import com.google.firebase.firestore.*


class AddressLiveData<Data>(private val ref :DocumentReference , private val type :Class<Data>) :LiveData<Result<Data>>() ,EventListener<DocumentSnapshot>{

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
                println("Docuemnt message ${document}")

                value=Result.Success(document)

            }

        }
    }





}