package image.crystalapps.kecommerce.data.database.firebase

import com.google.firebase.auth.FirebaseAuth

interface FirebaseManager {

    fun registerInstanceIdManager( uid :FirebaseAuth,newToken :String?)
}