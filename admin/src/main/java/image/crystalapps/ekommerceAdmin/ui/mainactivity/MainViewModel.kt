package image.crystalapps.ekommerceAdmin.ui.mainactivity

import android.app.Activity
import android.content.Intent
import android.view.View
import androidx.lifecycle.MediatorLiveData
import image.crystalapps.ekommerceAdmin.data.DataManager
import image.crystalapps.ekommercelibraries.ui.base.BaseActivity
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import javax.inject.Inject
import kotlin.reflect.KClass

class MainViewModel @Inject constructor(dataManager: DataManager):
    BaseViewModel<MainNavigator>(dataManager){
    val navigationLiveData = MediatorLiveData<KClass<out Activity>>()


    fun getNavigateLiveData() :MediatorLiveData<KClass<out Activity>>{
        return navigationLiveData }



   fun fashion(view: View ,activity :KClass<Activity>){
       navigationLiveData.value =activity
   }

    fun navigate(view :View ,activity :KClass<out Activity>){
        navigationLiveData.value =activity



    }



}