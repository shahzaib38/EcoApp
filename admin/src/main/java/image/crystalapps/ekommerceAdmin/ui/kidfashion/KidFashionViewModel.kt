package image.crystalapps.ekommerceAdmin.ui.kidfashion

import image.crystalapps.ekommerceAdmin.data.DataManager
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import javax.inject.Inject

class KidFashionViewModel  @Inject constructor(dataManager: DataManager):
    BaseViewModel<KidFashionNavigator>(dataManager)
