package image.crystalapps.kecommerce.ui.filter

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import javax.inject.Inject

class FilterViewModel @ViewModelInject constructor( val filterRepository: FilterRepository):
    BaseViewModel<FilterNavigator>(filterRepository){


}