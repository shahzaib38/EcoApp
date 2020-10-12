package image.crystalapps.ekommercelibraries.datai

import dagger.Module
import dagger.Provides
import image.crystalapps.ekommercelibraries.data.AppBaseDataManager
import image.crystalapps.ekommercelibraries.data.BaseDataManager

@Module
  class AppModule {


  @Provides
  fun getDataManager() : BaseDataManager { return AppBaseDataManager()
  }





}