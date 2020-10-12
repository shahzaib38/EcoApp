package image.crystalapps.ekommerceAdmin.ui.firebasedemo

import image.crystalapps.ekommerceAdmin.data.DataManager
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import javax.inject.Inject

class FireBaseMainViewModel @Inject constructor(val dataManager: DataManager):
    BaseViewModel<FirebaseMainNavigator>(dataManager)