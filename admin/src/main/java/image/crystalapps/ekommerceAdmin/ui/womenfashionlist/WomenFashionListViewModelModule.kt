package image.crystalapps.ekommerceAdmin.ui.womenfashionlist

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.ekommerceAdmin.di.activitiesbuilder.ViewModelKey
import image.crystalapps.ekommerceAdmin.ui.menfashionlist.MenFashionListViewModel

@Module
abstract class WomenFashionListViewModelModule {


    @IntoMap
    @ViewModelKey(MenFashionListViewModel::class)
    @Binds
    abstract fun bindWomenFashionListViewModel(menFashionListViewModel : MenFashionListViewModel): ViewModel


}