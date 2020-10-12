package image.crystalapps.ekommerceAdmin.ui.notification

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import image.crystalapps.ekommerceAdmin.BR

class SendNotificationBean  : BaseObservable() {


    @get:Bindable
    var firstName: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.firstName)
        }


}