package image.crystalapps.kecommerce.ui.mainactivity.fragments.notification

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.NotificationBean
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.launch

class NotificationViewModel  @ViewModelInject constructor(val dataManager: DataManager) :
    BaseViewModel<NotificationNavigator>(dataManager){



    val mUpdateEvent = MutableLiveData<Boolean>(false)



    val notificationLiveData =mUpdateEvent.switchMap {
        dataManager.getNotification().distinctUntilChanged().switchMap {data->
            filterData(data) } }



    private fun filterData(data : Result<List<NotificationBean>>) : LiveData<List<NotificationBean>> {
        val result = MutableLiveData<List<NotificationBean>>()

        if (data is Result.Success){
            viewModelScope.launch {
                result.value = data.data }}

        if(data is Result.Error){
            result.value = emptyList() }

        return result
    }

























}