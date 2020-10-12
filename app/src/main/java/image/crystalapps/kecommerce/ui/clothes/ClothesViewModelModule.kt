package image.crystalapps.kecommerce.ui.clothes

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.kecommerce.di.activitiesbuilder.ViewModelKey
import image.crystalapps.kecommerce.ui.mainactivity.MainViewModel

@Module
abstract class ClothesViewModelModule {



    @ViewModelKey(ClothesViewModel::class)
    @IntoMap
    @Binds
    abstract fun provideMainViewModel(clothesViewModel: ClothesViewModel): ViewModel


}