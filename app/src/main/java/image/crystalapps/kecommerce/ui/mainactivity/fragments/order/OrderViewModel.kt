package image.crystalapps.kecommerce.ui.mainactivity.fragments.order

import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import image.crystalapps.kecommerce.data.DataManager
import javax.inject.Inject

class OrderViewModel@Inject constructor(dataManager: DataManager):
    BaseViewModel<OrderViewModel>(dataManager)