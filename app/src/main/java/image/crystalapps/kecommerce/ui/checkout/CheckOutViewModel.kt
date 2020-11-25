package image.crystalapps.kecommerce.ui.checkout

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.data.database.prefs.SharedPreferenceEntry
import image.crystalapps.kecommerce.ui.base.BaseViewModel

class CheckOutViewModel @ViewModelInject constructor(val checkRepository: CheckRepository) : BaseViewModel<CheckOutNavigator>(checkRepository)  {


}
