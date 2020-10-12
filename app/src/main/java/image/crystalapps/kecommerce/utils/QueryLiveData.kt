package image.crystalapps.kecommerce.utils

import android.net.nsd.NsdManager
import androidx.lifecycle.LiveData
import com.google.firebase.firestore.*
import image.crystalapps.kecommerce.ui.Demo
import io.reactivex.rxjava3.kotlin.toObservable
import kotlin.reflect.KClass

class QueryLiveData<M :Model>(val query: Query, val type : Class<M>) :LiveData<Result<MutableList<M>>>() ,
    EventListener<QuerySnapshot> {
    private var register : ListenerRegistration?=null
    override fun onActive() {
        super.onActive()
       register= query.addSnapshotListener(this) }

    override fun onInactive() {
        super.onInactive()
        if(register!=null){
          register?.remove()
            register=null } }

    override fun onEvent(querySnapShot: QuerySnapshot?, error: FirebaseFirestoreException?) {
        if(error!=null){
            println("Error ${error.message}")
            value = Result.Error(error)
            return }
        if (querySnapShot!=null){
            println("Wokring Firebase ")
            value =Result.Success(createList(querySnapShot.documents)) }
    }

    private fun createList(documents: List<DocumentSnapshot>): MutableList<M> {
        val list =ArrayList<M>()
        println("Create List")
        for (document in documents){
            val model=    document.toObject(type)
            println("Model Object ${document.get("productName")}")
            if (model!=null){
                list.add(model) } }
        return list
    }


}