package image.crystalapps.ekommerceadmin.data

import android.app.Application
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import image.crystalapps.kecommerce.utils.FirebaseAuthentication
import image.crystalapps.kecommerce.utils.rx.RxSchedularProvider
import image.crystalapps.kecommerce.utils.rx.SchedularProvider
import io.reactivex.rxjava3.core.Observable

@Module
  class AppModule {


  @Provides
  fun getDataManager() : DataManager { return AppDataManager()
  }


  @Provides
  fun provideSchedularProvider(): SchedularProvider{

    return RxSchedularProvider()
  }


  @Provides
  fun provideGoogleSignInClient(application : Application) : GoogleSignInClient{
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
      .requestIdToken(FirebaseAuthentication.oAuthClientId)
      .requestEmail()
      .build()


    return GoogleSignIn.getClient(application, gso) }


  @Provides
  fun gerFirebaseAuth():FirebaseAuth{ return Firebase.auth }



}