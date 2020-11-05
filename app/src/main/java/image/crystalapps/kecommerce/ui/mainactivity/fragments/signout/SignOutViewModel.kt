package image.crystalapps.kecommerce.ui.mainactivity.fragments.signout

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import javax.inject.Inject

class SignOutViewModel  @ViewModelInject constructor(dataManager: DataManager):
    BaseViewModel<SignOutViewModel>(dataManager) {
}