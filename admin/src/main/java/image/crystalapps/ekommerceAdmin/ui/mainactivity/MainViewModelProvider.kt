package image.crystalapps.ekommerceAdmin.ui.mainactivity

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.ekommerceAdmin.di.activitiesbuilder.ViewModelKey

@Module
abstract class MainViewModelProvider {

    @ViewModelKey(MainViewModel::class)
    @IntoMap
    @Binds
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}