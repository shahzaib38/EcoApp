package image.crystalapps.ekommerceAdmin.ui.firebasedemo

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.ekommerceAdmin.di.activitiesbuilder.ViewModelKey

@Module
abstract class RestaurantViewModelModule {



    @IntoMap
    @ViewModelKey(RestaurantViewModel::class)
    @Binds
    abstract fun bindRestaurant2ViewModelViewModel(restaurantViewModel: RestaurantViewModel): ViewModel

}