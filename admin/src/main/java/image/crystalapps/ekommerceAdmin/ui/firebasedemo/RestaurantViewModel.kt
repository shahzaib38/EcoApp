package image.crystalapps.ekommerceAdmin.ui.firebasedemo

import image.crystalapps.ekommerceAdmin.data.DataManager
import image.crystalapps.ekommerceAdmin.ui.menfashion.MenFashionNavigator
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import javax.inject.Inject

class RestaurantViewModel @Inject constructor(val dataManager: DataManager):
    BaseViewModel<MenFashionNavigator>(dataManager)