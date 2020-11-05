package image.crystalapps.kecommerce.ui.mainactivity.fragments.popular

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel



class PopularViewModel  @ViewModelInject constructor (val dataManager: DataManager) :BaseViewModel<PopularNavigator>(dataManager) {
}