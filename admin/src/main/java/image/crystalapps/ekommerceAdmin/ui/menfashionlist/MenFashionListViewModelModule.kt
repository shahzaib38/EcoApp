package image.crystalapps.ekommerceAdmin.ui.menfashionlist

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.ekommerceAdmin.di.activitiesbuilder.ViewModelKey


@Module
abstract class MenFashionListViewModelModule {

    @IntoMap
    @ViewModelKey(MenFashionListViewModel::class)
    @Binds
    abstract fun bindMenFashionFragmentViewModel(menFashionListViewModel : MenFashionListViewModel): ViewModel



}