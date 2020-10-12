package image.crystalapps.ekommerceAdmin.ui.notification

import android.util.Log
import android.view.View
import androidx.databinding.*
import androidx.lifecycle.viewModelScope
import com.google.firebase.firestore.FirebaseFirestore
import image.crystalapps.ekommerceAdmin.data.DataManager
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

const val INITIAL_SECONDS_PER_WORK_SET = 5 // Seconds
 class SendNotificationViewModel @Inject constructor(val dataManager: DataManager): BaseViewModel<NotificationNavigator>(dataManager) ,Observable {

     val title =ObservableField<String>("")
     val description =ObservableField<String>("")



     fun sendNotification(view : View){
         viewModelScope.launch(Dispatchers.IO) {
         dataManager.sendNotification(title.get()!! ,description.get()!!)

         }


     }














     private val callbacks : PropertyChangeRegistry by lazy { PropertyChangeRegistry() }

     override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

         callbacks.remove(callback)
     }

     override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
         callbacks.remove(callback) }


     fun notifyChanged(){
         callbacks.notifyCallbacks(this ,0 ,null)

     }


     fun notifyPropertyChanged(field :Int){
         callbacks.notifyCallbacks(this ,field,null) }



     fun setDataChange(char :CharSequence)
    {
        Log.i("test" ,"$char")



}
 }