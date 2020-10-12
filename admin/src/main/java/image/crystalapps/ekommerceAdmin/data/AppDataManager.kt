package image.crystalapps.ekommerceAdmin.data

import androidx.lifecycle.LiveData
import image.crystalapps.ekommerceAdmin.model.MenFashionBean
import javax.inject.Inject

class AppDataManager @Inject constructor(val iCloudNotification : ICloudNotification ) : DataManager {



    override suspend fun  sendNotification(title :String ,body: String){
        iCloudNotification.sendNotification(title ,body)
    }

//    override suspend fun submitMenFashionData(menFashionBean: MenFashionBean) {
    //    menFirebase.submitMenFashionData(menFashionBean)
  ///  }


//  override fun  getSubmitLiveData()  : LiveData<String>{
  //      return menFirebase.submitMenFashionMutableLiveData
//    }




}