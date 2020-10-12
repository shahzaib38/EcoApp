package image.crystalapps.ekommerceAdmin.ui.womenfashionlist

import image.crystalapps.ekommerceAdmin.data.DataManager
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import javax.inject.Inject

class WomenFashionListViewModel  @Inject constructor(dataManager: DataManager):
    BaseViewModel<WomenFashionListNavigator>(dataManager)