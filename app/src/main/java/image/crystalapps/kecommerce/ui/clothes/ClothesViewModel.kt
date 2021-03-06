package image.crystalapps.kecommerce.ui.clothes

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.model.Filter
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.launch

class ClothesViewModel  @ViewModelInject constructor(private val clothesRepository: ClothesRepository) : BaseViewModel<CLothesNavigator>(clothesRepository) {

    val filter =MutableLiveData<Filter>()

    fun showFilterDialog(){ getNavigator().showFilterDialog() }
    fun showSortDialog(){ getNavigator().showSortDialog() }

    private fun filterData(data : Result<List<Products>>) :LiveData<List<Products>> {
        val result = MutableLiveData<List<Products>>()
        if (data is Result.Success){
            viewModelScope.launch {
                println(data.data)
                result.value = data.data}}
        if(data is Result.Error){

        }

        return result }


}