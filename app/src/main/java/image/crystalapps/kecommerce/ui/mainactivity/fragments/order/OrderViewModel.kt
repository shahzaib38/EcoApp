package image.crystalapps.kecommerce.ui.mainactivity.fragments.order

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import javax.inject.Inject

class OrderViewModel   @ViewModelInject constructor(dataManager: DataManager):
    BaseViewModel<OrderViewModel>(dataManager)