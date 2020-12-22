package image.crystalapps.kecommerce.data

import android.app.Application
import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import image.crystalapps.kecommerce.data.database.LocalDataBaseImpl
import image.crystalapps.kecommerce.data.database.LocalDataBaseManager
import image.crystalapps.kecommerce.data.database.firebase.FirebaseManager
import image.crystalapps.kecommerce.data.database.firebase.FirebaseManagerImpl
import image.crystalapps.kecommerce.data.database.firebase.InstanceIdManager
import image.crystalapps.kecommerce.data.database.prefs.SaveTokenSharedPreferenceHelper
import image.crystalapps.kecommerce.data.network.firebase.ServerFunctions
import image.crystalapps.kecommerce.data.network.firebase.ServerFunctionsImpl
import image.crystalapps.kecommerce.data.network.firebase.FirebaseAuthentication
import image.crystalapps.kecommerce.utils.PreferenceUtils
import image.crystalapps.kecommerce.utils.RxSchedularProvider
import image.crystalapps.kecommerce.utils.SchedularProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
class AppModule {



  @Provides
  fun getCoroutineIO() : CoroutineDispatcher{

    return Dispatchers.IO
  }


  @Provides
  fun provideLocalDataBaseManager(saveTokenSharedPreferenceHelper: SaveTokenSharedPreferenceHelper) :LocalDataBaseManager{
    return LocalDataBaseImpl(saveTokenSharedPreferenceHelper) }


  @Provides
  @Singleton
  fun provideServerFunctions() :ServerFunctions =ServerFunctionsImpl()



  @Singleton
  @Provides
  fun provideFirebaseManager(instanceIdManager: InstanceIdManager)  :FirebaseManager{
    return FirebaseManagerImpl(instanceIdManager) }


  @Provides
  fun provideInstanceManager() :InstanceIdManager{
    return InstanceIdManager() }




  @Provides
  fun provideDataManager(localDataBaseManager: LocalDataBaseManager ,firebaseManager: FirebaseManager) : DataManager {
    return AppDataManager(localDataBaseManager ,firebaseManager ,Dispatchers.IO) }


  @Provides
  fun provideSchedularProvider(): SchedularProvider {
    return RxSchedularProvider()
  }


  @Provides
  fun provideSaveTokenSharedPreferences(application: Application) :SaveTokenSharedPreferenceHelper{
    val sharedPreferences = application.getSharedPreferences(PreferenceUtils.TOKEN_PREFERENCES ,Context.MODE_PRIVATE)
    return SaveTokenSharedPreferenceHelper(sharedPreferences) }

  @Provides
  fun provideGoogleSignInClient(application : Application) : GoogleSignInClient{
    val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
      .requestIdToken(FirebaseAuthentication.oAuthClientId)
      .requestEmail()
      .build()


    return GoogleSignIn.getClient(application, gso) }
//
//
//  @Provides
//  fun gerFirebaseAuth():FirebaseAuth{ return Firebase.auth }



}