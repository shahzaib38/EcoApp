package image.crystalapps.kecommerce.ui.productselection

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.kecommerce.di.activitiesbuilder.ViewModelKey
import image.crystalapps.kecommerce.ui.clothes.ClothesViewModel

@Module
abstract class ProductViewModelModule {


    @ViewModelKey(ProductViewModel::class)
    @IntoMap
    @Binds
    abstract fun provideMainViewModel(productViewModel: ProductViewModel): ViewModel



}