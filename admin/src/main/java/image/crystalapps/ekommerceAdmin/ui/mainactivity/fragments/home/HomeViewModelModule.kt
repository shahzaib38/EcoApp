package image.crystalapps.ekommerceAdmin.ui.mainactivity.fragments.home

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.ekommerceAdmin.di.activitiesbuilder.ViewModelKey


@Module
abstract class HomeViewModelModule {



    @IntoMap
    @ViewModelKey(HomeViewModel::class)
    @Binds
    abstract fun bindHomeFragmentViewModel(homeViewModel: HomeViewModel): ViewModel

}