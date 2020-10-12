package image.crystalapps.kecommerce.data.database.firebase

import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject

class FirebaseManagerImpl @Inject constructor(private  val instanceIdManager: InstanceIdManager) :FirebaseManager {



    override fun registerInstanceIdManager(firebaseAuth :FirebaseAuth ,newToken: String?) {
        instanceIdManager.registerInstanceIdManager( firebaseAuth,newToken) }


}