package image.crystalapps.kecommerce.ui.mainactivity.fragments.popular

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.launch


class PopularViewModel  @ViewModelInject constructor (val dataManager: DataManager) :BaseViewModel<PopularNavigator>(dataManager) {




    val mUpdateEvent = MutableLiveData<Boolean>(false)



    val allProductsLiveData =mUpdateEvent.switchMap {
        dataManager.getAllProducts().distinctUntilChanged().switchMap {data->
            filterData(data)

        }

    }


//   fun filterAllProducts(data :Result<List<Products>>:LiveData<List<Products>>
//   {
//
//       val result =MutableLiveData<List<Products>>()
//
//       if (data is Result.Success){
//           viewModelScope.launch {
//
//               result.value= data.data
//
//           }
//       }
//
//       if(data is Result.Error){
//           result.value = emptyList()
//
//       }
//
//       return result
//   }

    private fun filterData(data : Result<List<Products>>) : LiveData<List<Products>> {
        val result = MutableLiveData<List<Products>>()

        if (data is Result.Success){
            viewModelScope.launch {


                result.value =data.data
            }
        }

        if(data is Result.Error){
            result.value = emptyList()

        }

        return result
    }












}