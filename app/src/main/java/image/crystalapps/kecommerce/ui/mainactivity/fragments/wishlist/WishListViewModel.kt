package image.crystalapps.kecommerce.ui.mainactivity.fragments.wishlist

import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import image.crystalapps.kecommerce.data.DataManager
import javax.inject.Inject

class WishListViewModel @Inject constructor(dataManager: DataManager):
    BaseViewModel<WishListNavigator>(dataManager) {
}