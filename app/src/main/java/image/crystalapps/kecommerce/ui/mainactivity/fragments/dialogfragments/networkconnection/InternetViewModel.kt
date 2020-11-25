package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.networkconnection

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.ui.mainactivity.MainRepository


class InternetViewModel @ViewModelInject constructor(val mainRepository : MainRepository) :
    BaseViewModel<InternetNavigator>(mainRepository) {


      fun dismissDialog(){
          getNavigator().dismissDialog()

    }


}