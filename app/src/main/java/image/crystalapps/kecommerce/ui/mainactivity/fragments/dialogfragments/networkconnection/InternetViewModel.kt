package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.networkconnection

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel


class InternetViewModel @ViewModelInject constructor(dataManager: DataManager) :
    BaseViewModel<InternetNavigator>(dataManager) {


      fun dismissDialog(){
          getNavigator().dismissDialog()

    }


}