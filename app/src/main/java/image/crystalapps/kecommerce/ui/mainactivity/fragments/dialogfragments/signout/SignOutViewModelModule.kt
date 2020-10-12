package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.signout

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.kecommerce.di.activitiesbuilder.ViewModelKey


@Module
abstract  class SignOutViewModelModule {


    @IntoMap
    @ViewModelKey(SignOutViewModel::class)
    @Binds
    abstract fun bindFirebaseAuthenticationViewModel(signOutViewModel: SignOutViewModel): ViewModel


}