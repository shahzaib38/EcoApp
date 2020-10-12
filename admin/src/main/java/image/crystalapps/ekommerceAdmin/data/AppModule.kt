package image.crystalapps.ekommerceAdmin.data

import android.app.Application
import dagger.Module
import dagger.Provides
import image.crystalapps.ekommerceAdmin.Utils.NotificationUtils.NotificationUtils.BASEURL
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
  class AppModule {

  @CustomScope
  @Provides
  fun getDataManager(iCloudNotification : ICloudNotification) : DataManager { return AppDataManager(iCloudNotification) }


  @CustomScope
  @Provides
  fun provideRetrofit(): Retrofit{
    return Retrofit.Builder()
      .baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create())
      .build()
  }


  @CustomScope
  @Provides
  fun provideMyNotification(retrofit: Retrofit): IMyNotification {
    return retrofit.create(IMyNotification::class.java)
  }
  @CustomScope
  @Provides
  fun provideINotification(iMyNotification: IMyNotification, context: Application): ICloudNotification {
    return CloudNotification(iMyNotification, context)
  }


}