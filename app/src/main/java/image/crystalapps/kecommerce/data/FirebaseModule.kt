package image.crystalapps.kecommerce.data

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent


@Module
@InstallIn(ApplicationComponent::class)
class FirebaseModule {



    @Provides
    fun getColltectionReference() : CollectionReference {
        return Firebase.firestore.collection("users") }

    @Provides
    fun getFireBaseAuth() :FirebaseAuth {
        return  Firebase.auth }


}