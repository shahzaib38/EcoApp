package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.profiledialog

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel

class ProfileDialogViewModel  @ViewModelInject constructor(dataManager: DataManager) : BaseViewModel<ProfileDialogNavigator>(dataManager) {



   fun  submit(){
       getNavigator().submit() }


}