package image.crystalapps.kecommerce.ui.mainactivity.fragments.related

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.Clothes
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.ui.mainactivity.MainRepository
import image.crystalapps.kecommerce.utils.FirebaseUtils
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.launch

class RelatedViewModel   @ViewModelInject  constructor(val mainRepository: MainRepository)  :BaseViewModel<RelatedNavigator>(mainRepository) {




    val mUpdateEvent =MutableLiveData<Boolean>(false)


    val allProductsLiveData =mUpdateEvent.switchMap {
        mainRepository.loadRelatedProducts("Men" ,"T-Shirt").distinctUntilChanged().switchMap {data->
            filterData(data)

        }

    }


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