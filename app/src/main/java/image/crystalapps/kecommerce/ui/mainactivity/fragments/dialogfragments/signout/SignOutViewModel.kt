package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.signout

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.ui.mainactivity.MainRepository
import javax.inject.Inject

class SignOutViewModel @ViewModelInject constructor(val mainRepository :MainRepository) :
    BaseViewModel<SignOutNavigator>(mainRepository) {


}