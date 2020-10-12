package image.crystalapps.kecommerce.ui.mainactivity.fragments.cart

import androidx.lifecycle.*
import image.crystalapps.Products
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class CartViewModel @Inject constructor(dataManager: DataManager):
    BaseViewModel<CartNavigator>(dataManager){



    val mUpdateEvent =MutableLiveData<Boolean>(false)


    val allCartLiveDataManager =mUpdateEvent.switchMap {
        dataManager.getCartItem().distinctUntilChanged().switchMap {data->
            filterData(data)

        }



    }


    private fun filterData(data : Result<List<Products>>) : LiveData<List<Products>> {
        val result = MutableLiveData<List<Products>>()

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