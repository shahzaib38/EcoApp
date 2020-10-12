package image.crystalapps.kecommerce.di.servicesbuilder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import image.crystalapps.kecommerce.services.BaseIntentService

@Module
abstract class ServiceBuilders {



    @ContributesAndroidInjector()
    abstract fun baseIntentService() : BaseIntentService




}