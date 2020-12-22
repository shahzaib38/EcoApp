package image.crystalapps.kecommerce.data.network.firebase

import com.google.firebase.auth.FirebaseUser
import image.crystalapps.kecommerce.model.UserProfile
import image.crystalapps.kecommerce.utils.ProductLiveData

interface FirebaseAuthSource {

    fun getUserProfileData(firebaseUser: FirebaseUser) : ProductLiveData<UserProfile>

}