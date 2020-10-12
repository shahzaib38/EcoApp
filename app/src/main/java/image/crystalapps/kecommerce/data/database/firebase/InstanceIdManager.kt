package image.crystalapps.kecommerce.data.database.firebase

import android.media.MediaPlayer
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import image.crystalapps.kecommerce.utils.FirebaseUtils
import java.util.*
import javax.inject.Inject

class InstanceIdManager @Inject constructor()  {



  fun   registerInstanceIdManager(firebaseAuth : FirebaseAuth, newToken :String?){
      println("Checking first")

      val mCurrentUser= firebaseAuth.currentUser ?: return

      println("Checking")
       val userCollection= Firebase.firestore.collection(FirebaseUtils.USER_COLLECTION)
       val userDocuments=  userCollection.document(mCurrentUser.uid)

      userDocuments.get().addOnCompleteListener( object :OnCompleteListener<DocumentSnapshot>{
          override fun onComplete(task: Task<DocumentSnapshot>) {
              if (task.isSuccessful){
                  val documentResult  =   task.result
                  if (documentResult!=null){
                      if (documentResult.exists()){
                          val resultMap =       documentResult.data
                          if (resultMap!=null) {
                           val result=resultMap["fcmTokens"]
                          val hashMap=     hashMapOf<String,Any>()
                              val token =newToken?:""
                          val arrayList=      arrayListOf(token)
                          hashMap.put("fcmTokens" ,arrayList )
                          userDocuments.update(hashMap) } }

                      else{

                      val hashMap=     hashMapOf<String,Any>()
                          val token =newToken?:""
                      val arrayList=      arrayListOf(newToken)
                      hashMap.put("fcmTokens" ,arrayList )
                      userDocuments.set(hashMap)
                  }




              }else{
                  println("exception")

              }
              }


          }


      }
      )







      }



}



