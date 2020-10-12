package image.crystalapps.kecommerce.ui.mainactivity.fragments.order

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.kecommerce.di.activitiesbuilder.ViewModelKey
import image.crystalapps.kecommerce.ui.mainactivity.fragments.home.HomeViewModel

@Module
abstract class OrderViewModelModule {


    @IntoMap
    @ViewModelKey(OrderViewModel::class)
    @Binds
    abstract fun bindOrderFragmentViewModel(orderViewModel : OrderViewModel): ViewModel


}