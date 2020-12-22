package image.crystalapps.kecommerce.data.network.firebase

import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.CollectionReference
import image.crystalapps.kecommerce.model.UserProfile
import image.crystalapps.kecommerce.utils.ProductLiveData
import javax.inject.Inject

class FireStoreAuth @Inject constructor(val collectionReference: CollectionReference)  {


//    fun getUserProfileData(firebaseUser: FirebaseUser) : ProductLiveData<UserProfile> {
//        val documentReference=  collectionReference.document(firebaseUser.uid)
//
//
//     val task=   documentReference.get().addOnCompleteListener {
//
//        }
//
//
//
//     //    val result =  documentReference.get().result
//
//
//   //     val userProfile= ProductLiveData(
//          //      documentReference,
//            //    UserProfile::class.java
//        //    )
//          //  documentReference.addSnapshotListener(userProfile)
//        //    return userProfile
//
//
//
//    }



}