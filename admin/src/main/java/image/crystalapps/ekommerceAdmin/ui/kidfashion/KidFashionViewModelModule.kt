package image.crystalapps.ekommerceAdmin.ui.kidfashion

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.ekommerceAdmin.di.activitiesbuilder.ViewModelKey

@Module
abstract class KidFashionViewModelModule{


    @IntoMap
    @ViewModelKey(KidFashionViewModel::class)
    @Binds
    abstract fun bindKidFashionViewModel(kidFashionViewModel : KidFashionViewModel): ViewModel


}