package image.crystalapps.kecommerce.ui.mainactivity.fragments.cart

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.kecommerce.di.activitiesbuilder.ViewModelKey
import image.crystalapps.kecommerce.ui.mainactivity.fragments.home.HomeViewModel

@Module
abstract class CartViewModelModule {

    @IntoMap
    @ViewModelKey(CartViewModel::class)
    @Binds
    abstract fun bindCartFragmentViewModel(homeViewModel : CartViewModel): ViewModel

}