package image.crystalapps.ekommerceAdmin.data

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import image.crystalapps.ekommerceAdmin.di.activitiesbuilder.ActivityBuilderModule
import image.crystalapps.ekommerceAdmin.di.activitiesbuilder.ViewModelProviderFactoryModule
import image.crystalapps.ekommerceAdmin.di.broadcastbuilder.BroadCastRecieverBuilders
import image.crystalapps.ekommerceAdmin.di.contentbuilder.ContentProviderBuilders
import image.crystalapps.ekommerceAdmin.di.servicesbuilder.ServiceBuilders
import image.crystalapps.ekommercelibraries.data.BaseComponent


@CustomScope
@Component(dependencies = [BaseComponent::class] ,modules = [AndroidSupportInjectionModule::class,
    ActivityBuilderModule::class, AppModule::class, ViewModelProviderFactoryModule::class, ServiceBuilders::class,
    BroadCastRecieverBuilders::class, ContentProviderBuilders::class])
interface EkommerceAdminComponent : AndroidInjector<AdminApplication> {

    override fun inject(instance: AdminApplication?)
    @Component.Factory
    interface Factory{
        fun create(@BindsInstance application: Application ,baseComponent: BaseComponent):EkommerceAdminComponent
    }}