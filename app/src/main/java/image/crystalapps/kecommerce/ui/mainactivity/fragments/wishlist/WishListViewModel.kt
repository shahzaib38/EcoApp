package image.crystalapps.kecommerce.ui.mainactivity.fragments.wishlist

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import javax.inject.Inject

class WishListViewModel @ViewModelInject constructor(dataManager: DataManager):
    BaseViewModel<WishListNavigator>(dataManager) {
}