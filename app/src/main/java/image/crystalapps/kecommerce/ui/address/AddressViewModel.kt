package image.crystalapps.kecommerce.ui.address

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel


class AddressViewModel @ViewModelInject constructor(val  dataManager: DataManager) :BaseViewModel<AddressNavigator>(dataManager) {


}