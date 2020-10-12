package image.crystalapps.ekommerceAdmin.ui.menfashion

import android.text.TextUtils
import android.view.View
import android.widget.RadioGroup
import androidx.databinding.ObservableBoolean
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import image.crystalapps.ekommerceAdmin.R
import image.crystalapps.ekommerceAdmin.data.DataManager
import image.crystalapps.ekommerceAdmin.model.MenFashionBean
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenFashionViewModel @Inject constructor(val dataManager: DataManager):
    BaseViewModel<MenFashionNavigator>(dataManager)  {

    val titleErrorCheck =ObservableBoolean(true)
    val descriptionCheck =ObservableBoolean(true)
    val productCheck = ObservableBoolean(true)
    val prizeCheck =ObservableBoolean(true)




    fun isPrizeEmpty(prize :String) :Boolean{
        if (TextUtils.isEmpty(prize)) {
            prizeCheck.set(false)
            return false }
        prizeCheck.set(true)
        return true }



    fun isTitleEmpty(title :String) :Boolean{
        if (TextUtils.isEmpty(title)) {
            titleErrorCheck.set(false)
            return false }
            titleErrorCheck.set(true)
             return true }

    fun  isDescriptionEmpty(description :String) :Boolean{

        if (TextUtils.isEmpty(description)) {
            descriptionCheck.set(false)
            return false }
        descriptionCheck.set(true)
        return true
    }

    fun isProductNameEmpty(productName :String) :Boolean{
        if(TextUtils.isEmpty(productName)) {
            this.productCheck.set(false)
            return false }

        this.productCheck.set(true)
        return true }

    fun add(view : View){}
//
//
//    fun getSubmitLiveData() :LiveData<String>{
//        return dataManager.getSubmitLiveData()
//    }
//


    fun setCheckChanged(group: RadioGroup?, checkedId: Int){

        when(checkedId) {
            R.id.jeans -> {
                getNavigator().setType("Jeans")
            }
            R.id.shirts->{
                getNavigator().setType("Shirts")
            }

            R.id.shoes->
                getNavigator().setType("Shoes")
            }


        }




    fun submitMenFashionData(menFashionBean: MenFashionBean){

        viewModelScope.launch {
        //    dataManager.submitMenFashionData(menFashionBean)
        }

   }


















    fun submitDataToDataBase(view :View){
        getNavigator().submitData()

    }


}