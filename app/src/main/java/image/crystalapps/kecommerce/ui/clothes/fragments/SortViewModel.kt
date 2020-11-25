package image.crystalapps.kecommerce.ui.clothes.fragments

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel

class SortViewModel @ViewModelInject constructor(val sortRepository: SortRepository) :
    BaseViewModel<SortNavigator>(sortRepository) {

}