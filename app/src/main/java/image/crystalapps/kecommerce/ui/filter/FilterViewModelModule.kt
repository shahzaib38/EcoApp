package image.crystalapps.kecommerce.ui.filter

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.kecommerce.di.activitiesbuilder.ViewModelKey

@Module
abstract class FilterViewModelModule {

    @ViewModelKey(FilterViewModel::class)
    @IntoMap
    @Binds
    abstract fun provideFilterActivityViewModel(filterViewModel : FilterViewModel): ViewModel



}