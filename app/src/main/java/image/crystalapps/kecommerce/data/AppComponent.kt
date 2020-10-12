package image.crystalapps.kecommerce.data

import  android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import image.crystalapps.ekommercelibraries.data.BaseComponent
import image.crystalapps.kecommerce.data.database.CustomScope
import image.crystalapps.kecommerce.di.activitiesbuilder.ActivityBuilderModule
import image.crystalapps.kecommerce.di.activitiesbuilder.ViewModelProviderFactoryModule
import image.crystalapps.kecommerce.di.broadcastbuilder.BroadCastRecieverBuilders
import image.crystalapps.kecommerce.di.contentbuilder.ContentProviderBuilders
import image.crystalapps.kecommerce.di.servicesbuilder.ServiceBuilders


@CustomScope
@Component(
    modules = [AndroidSupportInjectionModule::class, ActivityBuilderModule::class, AppModule::class,
        ViewModelProviderFactoryModule::class, ServiceBuilders::class, BroadCastRecieverBuilders::class,
        ContentProviderBuilders::class] , dependencies =[ BaseComponent::class])

interface AppComponent : AndroidInjector<ClientApplication> {

    override fun inject(instance: ClientApplication?);

    @Component.Factory
    interface Factory{
        fun create(@BindsInstance application: Application ,baseComponent: BaseComponent):AppComponent
    }





}