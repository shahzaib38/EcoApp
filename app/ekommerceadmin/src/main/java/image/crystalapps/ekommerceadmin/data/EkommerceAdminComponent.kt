package image.crystalapps.ekommerceadmin.data

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import image.crystalapps.ekommercelibraries.data.ApplicationScope
import image.crystalapps.ekommercelibraries.data.BaseApplication
import image.crystalapps.ekommercelibraries.data.BaseComponent
import image.crystalapps.ekommercelibraries.datai.AppModule
import image.crystalapps.ekommercelibraries.di.activitiesbuilder.ActivityBuilderModule
import image.crystalapps.ekommercelibraries.di.activitiesbuilder.ViewModelProviderFactoryModule
import image.crystalapps.ekommercelibraries.di.broadcastbuilder.BroadCastRecieverBuilders
import image.crystalapps.ekommercelibraries.di.contentbuilder.ContentProviderBuilders
import image.crystalapps.ekommercelibraries.di.servicesbuilder.ServiceBuilders
import javax.inject.Scope
import javax.inject.Singleton


@CustomScope
@Component(dependencies = [BaseComponent::class] ,modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class, AppModule::class, ViewModelProviderFactoryModule::class, ServiceBuilders::class, BroadCastRecieverBuilders::class, ContentProviderBuilders::class])
interface EkommerceAdminComponent : AndroidInjector<AdminApplication> {

    override fun inject(instance: AdminApplication?)




    @Component.Factory
    interface Factory{
        fun create(@BindsInstance application: Application ,baseComponent: BaseComponent):EkommerceAdminComponent
    }}