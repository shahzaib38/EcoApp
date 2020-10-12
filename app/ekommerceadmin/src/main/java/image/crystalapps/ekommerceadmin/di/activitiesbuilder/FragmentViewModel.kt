package image.crystalapps.ekommerceadmin.di.activitiesbuilder

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class FragmentViewModel {


    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    @Binds
    abstract fun bindLoginFragmentViewModel(loginViewModel: LoginViewModel):ViewModel

}