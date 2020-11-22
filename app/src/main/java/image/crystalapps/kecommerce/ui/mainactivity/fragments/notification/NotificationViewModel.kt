package image.crystalapps.kecommerce.ui.mainactivity.fragments.notification

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel

class NotificationViewModel  @ViewModelInject constructor(val dataManager: DataManager) : BaseViewModel<NotificationNavigator>(dataManager) {

}