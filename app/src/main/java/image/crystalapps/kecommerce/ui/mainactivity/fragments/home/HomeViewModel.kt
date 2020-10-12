package image.crystalapps.kecommerce.ui.mainactivity.fragments.home


import androidx.lifecycle.*
import image.crystalapps.Products
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.Categories
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class HomeViewModel @Inject constructor(private val dataManager: DataManager):
            BaseViewModel<HomeNavigator>(dataManager) {

    val mUpdateEvent =MutableLiveData<Boolean>(false)

    val categoriesLiveData =MutableLiveData<List<Categories>>()

   fun setUpCategories(){
       val categoriesData = ArrayList<Categories>()
       categoriesData.add(Categories("Men",null))
       categoriesData.add(Categories("Women",null))
       categoriesLiveData.value=categoriesData
    }






   val allProductsLiveData =mUpdateEvent.switchMap {
       dataManager.getAllProducts().distinctUntilChanged().switchMap {data->
           filterData(data)

     }



   }


    private fun filterData(data :Result<List<Products>>) :LiveData<List<Products>>{
        val result =MutableLiveData<List<Products>>()

        if (data is Result.Success){
            viewModelScope.launch {
                result.value=data.data }
        }

        if(data is Result.Error){
            println("Error is cominng")
        }

        return result
    }



}