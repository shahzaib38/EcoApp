package image.crystalapps.kecommerce.ui.productselection.dialogfragment

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import javax.inject.Inject


class FilterViewModel @ViewModelInject constructor(val dataManager: DataManager) :
    BaseViewModel<FilterNavigator>(dataManager)

{

    fun filter(){
        getNavigator().filter()
    }

}






