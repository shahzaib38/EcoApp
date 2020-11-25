package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.profiledialog

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.ui.mainactivity.MainRepository

class ProfileDialogViewModel  @ViewModelInject constructor(val mainRepository : MainRepository) : BaseViewModel<ProfileDialogNavigator>(mainRepository) {



   fun  submit(){
       getNavigator().submit() }


}