package image.crystalapps.ekommerceAdmin.ui.womenfashion

import image.crystalapps.ekommerceAdmin.data.DataManager
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import javax.inject.Inject

class WomenFashionViewModel  @Inject constructor(dataManager: DataManager):
    BaseViewModel<WomenFashionNavigator>(dataManager)
