package image.crystalapps.kecommerce.ui.filter

import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import image.crystalapps.kecommerce.data.DataManager
import javax.inject.Inject

class FilterViewModel @Inject constructor(val dataManager :DataManager):BaseViewModel<FilterNavigator>(dataManager)