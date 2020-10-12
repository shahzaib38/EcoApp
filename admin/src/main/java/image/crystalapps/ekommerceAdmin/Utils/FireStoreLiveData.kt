package image.crystalapps.ekommerceAdmin.Utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.firebase.ui.auth.data.model.Resource
import com.google.firebase.firestore.*
import com.google.firebase.firestore.ktx.toObject
import image.crystalapps.ekommerceAdmin.model.MenFashionBean
import image.crystalapps.ekommerceAdmin.ui.firebasedemo.Restaurant
import javax.inject.Inject
import kotlin.reflect.KClass

//
//class  FireStoreLiveData (val query : Query ,val type : Restaurant): LiveData<List<Restaurant>>() , EventListener<QuerySnapshot>{
//
//    var register :ListenerRegistration? =null
//
//
//
//
//    override fun onEvent(snapshot: QuerySnapshot?, e: FirebaseFirestoreException?) {
//
//        if (e!=null){
//            println("Error "+e.message)
//
//        }
//
//        value =documentToList(snapshot)
//
//    }
//
//    fun  documentToList(querySnapShot : QuerySnapshot?) :List<Restaurant>{
//
//     val   returnList :ArrayList<Restaurant>  =ArrayList()
//
//        if (returnList.isEmpty()){
//            return returnList }
//
//        if (querySnapShot!=null) {
//            for (queryDocumentSnapShot in querySnapShot.documents) {
//
//             //   returnList.add(queryDocumentSnapShot.d)
//
//            }
//        }
//
//        return returnList
//    }
//
//    override fun onActive() {
//        super.onActive()
//
//        if (register==null) {
//            register = query.addSnapshotListener(this)
//       }
//    }
//
//
//    override fun onInactive() {
//        super.onInactive()
//
//        if (register!=null){
//                register?.remove()
//                 register= null }
//
//    }
//
//}