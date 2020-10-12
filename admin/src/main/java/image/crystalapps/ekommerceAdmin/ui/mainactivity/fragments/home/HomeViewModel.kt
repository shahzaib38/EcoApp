package image.crystalapps.ekommerceAdmin.ui.mainactivity.fragments.home

import image.crystalapps.ekommerceAdmin.data.DataManager
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor(dataManager: DataManager):
    BaseViewModel<HomeNavigator>(dataManager)