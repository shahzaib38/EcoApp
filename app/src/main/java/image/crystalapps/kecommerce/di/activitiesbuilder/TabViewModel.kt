package image.crystalapps.kecommerce.di.activitiesbuilder

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.kecommerce.ui.mainactivity.MainViewModel

@Module
abstract class TabViewModel {

    @IntoMap
    @ViewModelKey(MainViewModel::class)
    @Binds
    abstract fun bindLoginFragmentViewModel(loginViewModel: MainViewModel): ViewModel

}