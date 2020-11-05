package image.crystalapps.kecommerce.ui.mainactivity.fragments.categories

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import javax.inject.Inject

class CategoriesViewModel  @ViewModelInject constructor(dataManager: DataManager):
    BaseViewModel<CategoriesNavigator>(dataManager) {
}