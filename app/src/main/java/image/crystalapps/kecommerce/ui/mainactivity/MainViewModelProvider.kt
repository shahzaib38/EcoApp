package image.crystalapps.kecommerce.ui.mainactivity

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.kecommerce.di.activitiesbuilder.ViewModelKey

@Module
abstract class MainViewModelProvider {

    @ViewModelKey(MainViewModel::class)
    @IntoMap
    @Binds
    abstract fun provideMainViewModel(mainViewModel: MainViewModel): ViewModel



}