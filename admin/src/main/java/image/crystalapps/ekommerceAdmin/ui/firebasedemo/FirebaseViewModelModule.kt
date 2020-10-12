package image.crystalapps.ekommerceAdmin.ui.firebasedemo

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.ekommerceAdmin.di.activitiesbuilder.ViewModelKey


@Module
abstract class FirebaseViewModelModule {



    @IntoMap
    @ViewModelKey(FireBaseMainViewModel::class)
    @Binds
    abstract fun bindFireBaseViewModelFragmentViewModel(firebaseMainViewmodel: FireBaseMainViewModel): ViewModel



}