package image.crystalapps.ekommerceadmin.di.servicesbuilder

import   dagger.Module
import dagger.android.ContributesAndroidInjector
import image.crystalapps.ekommercelibraries.services.BaseIntentService


@Module
abstract class ServiceBuilders {



    @ContributesAndroidInjector()
    abstract fun baseIntentService() : BaseIntentService




}