package image.crystalapps.kecommerce.data.database.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import image.crystalapps.kecommerce.model.UserProfile
import image.crystalapps.kecommerce.utils.FirebaseUtils

object FirebaseUserProfile {



    fun uploadUserData(userProfile :Map<String,String>){

        val mCurrentUser= FirebaseAuth.getInstance().currentUser ?: return
        val userCollection= Firebase.firestore.collection("users")
        val userDocuments=  userCollection.document(mCurrentUser.uid)

        userDocuments.get().addOnCompleteListener { task ->
            if (task.isSuccessful){
                val documentResult  =   task.result
                if (documentResult!=null){
                    if (documentResult.exists()){
                        val resultMap =       documentResult.data
                        if (resultMap!=null) {

                         userDocuments.update(userProfile)

                        } else throw NullPointerException("InstanceIdManager Register Instance Id ResultMap is null")


                    } else{

                        userDocuments.set(userProfile)


                    }

                } else throw NullPointerException("InstanceIdManager Document Result is null")
            }
        }

    }




}