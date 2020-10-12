package image.crystalapps.ekommerceAdmin.ui.womenfashion

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.ekommerceAdmin.di.activitiesbuilder.ViewModelKey
import image.crystalapps.ekommerceAdmin.ui.menfashion.MenFashionViewModel
import image.crystalapps.ekommerceAdmin.ui.menfashionlist.MenFashionListViewModel

@Module
abstract class WomenFashionViewModelModule {



    @IntoMap
    @ViewModelKey(MenFashionListViewModel::class)
    @Binds
    abstract fun bindWomenFashionFragmentViewModel(womenFashionViewModel : MenFashionViewModel): ViewModel


}