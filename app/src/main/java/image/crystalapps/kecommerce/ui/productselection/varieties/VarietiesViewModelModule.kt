package image.crystalapps.kecommerce.ui.productselection.varieties

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.kecommerce.di.activitiesbuilder.ViewModelKey
import image.crystalapps.kecommerce.ui.productselection.ProductViewModel


@Module
abstract class VarietiesViewModelModule {




    @ViewModelKey(VarietiesViewModel::class)
    @IntoMap
    @Binds
    abstract fun provideMainViewModel(varietiesViewModel: VarietiesViewModel): ViewModel




}