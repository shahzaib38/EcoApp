package image.crystalapps.kecommerce.ui.mainactivity.fragments.wishlist

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.kecommerce.di.activitiesbuilder.ViewModelKey
import image.crystalapps.kecommerce.ui.mainactivity.fragments.categories.CategoriesViewModel
import image.crystalapps.kecommerce.ui.mainactivity.fragments.order.OrderViewModel

@Module
abstract class WishListViewModelModule {

    @IntoMap
    @ViewModelKey(WishListViewModel::class)
    @Binds
    abstract fun bindWishListFragmentViewModel(wishListViewModel : WishListViewModel): ViewModel


}