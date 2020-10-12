package image.crystalapps.ekommerceAdmin.ui.menfashion

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.ekommerceAdmin.di.activitiesbuilder.ViewModelKey

@Module
abstract class MenFashionViewModelModule {


    @IntoMap
    @ViewModelKey(MenFashionViewModel::class)
    @Binds
    abstract fun bindMenFashionFragmentViewModel(menFashionViewModel: MenFashionViewModel): ViewModel


}