package image.crystalapps.ekommercelibraries.data

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import image.crystalapps.ekommercelibraries.datai.AppModule
import image.crystalapps.ekommercelibraries.di.activitiesbuilder.ActivityBuilderModule
import image.crystalapps.ekommercelibraries.di.activitiesbuilder.ViewModelProviderFactoryModule
import image.crystalapps.ekommercelibraries.di.broadcastbuilder.BroadCastRecieverBuilders
import image.crystalapps.ekommercelibraries.di.contentbuilder.ContentProviderBuilders
import image.crystalapps.ekommercelibraries.di.servicesbuilder.ServiceBuilders
import javax.inject.Singleton

@ApplicationScope
@Component(modules = arrayOf(
    AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class,
    AppModule::class,
    ViewModelProviderFactoryModule::class ,
    ServiceBuilders::class,
    BroadCastRecieverBuilders::class,
    ContentProviderBuilders::class
))

 interface BaseComponent : AndroidInjector<BaseApplication> {






}