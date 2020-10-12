package image.crystalapps.kecommerce.ui.clothes

import androidx.lifecycle.*
import image.crystalapps.Products
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.launch
import javax.inject.Inject

class ClothesViewModel  @Inject constructor(private val dataManager: DataManager) :BaseViewModel<CLothesNavigator>(dataManager) {



    val _AllProductsLiveData =MutableLiveData<List<Products>>()

    val allProductsLiveData :LiveData<List<Products>> = _AllProductsLiveData


    fun setClothData(categoryName :String):LiveData<List<Products>>{

        return dataManager.getClothesData(categoryName).distinctUntilChanged().switchMap {data->
            filterData(data) }



    }

    private fun filterData(data : Result<List<Products>>) : LiveData<List<Products>> {
        val result = MutableLiveData<List<Products>>()
        if (data is Result.Success){
            viewModelScope.launch { result.value=data.data } }
        if(data is Result.Error){}
        return result }


}