package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.networkconnection

import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import image.crystalapps.kecommerce.data.DataManager
import javax.inject.Inject

class InternetViewModel @Inject constructor(dataManager: DataManager) :BaseViewModel<InternetNavigator>(dataManager) {


      fun dismissDialog(){
          getNavigator().dismissDialog()

    }


}