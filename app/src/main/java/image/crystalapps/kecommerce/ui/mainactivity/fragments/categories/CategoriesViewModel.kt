package image.crystalapps.kecommerce.ui.mainactivity.fragments.categories

import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import image.crystalapps.kecommerce.data.DataManager
import javax.inject.Inject

class CategoriesViewModel@Inject constructor(dataManager: DataManager):
    BaseViewModel<CategoriesNavigator>(dataManager) {
}