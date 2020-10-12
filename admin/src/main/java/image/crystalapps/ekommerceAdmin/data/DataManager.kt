package image.crystalapps.ekommerceAdmin.data

import androidx.lifecycle.LiveData
import image.crystalapps.ekommerceAdmin.model.MenFashionBean
import image.crystalapps.ekommercelibraries.data.BaseDataManager

interface DataManager :BaseDataManager{

    suspend fun  sendNotification(title :String ,body: String)

  //  suspend fun submitMenFashionData(menFashionBean: MenFashionBean)

//    fun  getSubmitLiveData()  : LiveData<String>


}