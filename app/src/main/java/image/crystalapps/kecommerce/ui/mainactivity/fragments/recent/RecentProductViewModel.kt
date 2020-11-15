package image.crystalapps.kecommerce.ui.mainactivity.fragments.recent

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.Clothes
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.utils.FirebaseUtils
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.launch

class RecentProductViewModel @ViewModelInject constructor(val dataManager: DataManager) :BaseViewModel<RecentProductsNavigator>(dataManager) {


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

    private fun createClothList(list: List<Products>) :List<Clothes> {

        val listProducts =ArrayList<Clothes>()
        var categoriesNaem=""
        val products =ArrayList<Products>()

        for(listValues in list) {
            val categoryName=  listValues.categoryName

            categoriesNaem=  when(categoryName){
                FirebaseUtils.MEN->{
                    products.add(listValues)
                    FirebaseUtils.MEN }

                FirebaseUtils.WOMEN->{

                    products.add(listValues)
                    FirebaseUtils.WOMEN

                }else->{
                    "" } } }


        listProducts.add(Clothes(categoriesNaem ,products))

        return listProducts }




}