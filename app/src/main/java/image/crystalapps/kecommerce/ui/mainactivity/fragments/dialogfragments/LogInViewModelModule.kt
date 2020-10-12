package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.kecommerce.di.activitiesbuilder.ViewModelKey

@Module
abstract class LogInViewModelModule {

    @IntoMap
    @ViewModelKey(LogInViewModel::class)
    @Binds
    abstract fun bindFirebaseAuthenticationViewModel(logInViewModel: LogInViewModel): ViewModel


}