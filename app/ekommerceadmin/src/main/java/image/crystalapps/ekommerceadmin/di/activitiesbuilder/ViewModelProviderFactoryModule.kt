package image.crystalapps.ekommerceadmin.di.activitiesbuilder

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import image.crystalapps.ekommercelibraries.viewmodel.ViewModelProviderFactory


@Module
abstract  class ViewModelProviderFactoryModule {
    @Binds
    abstract  fun bindViewModelProviderFactory(viewModelProviderFactory : ViewModelProviderFactory):ViewModelProvider.Factory }