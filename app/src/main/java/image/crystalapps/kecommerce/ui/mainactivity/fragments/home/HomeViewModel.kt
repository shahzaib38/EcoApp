package image.crystalapps.kecommerce.ui.mainactivity.fragments.home


import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.PagingData
import com.google.firebase.ktx.Firebase
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.model.Categories
import image.crystalapps.kecommerce.model.Clothes
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.ui.clothes.CLothesNavigator
import image.crystalapps.kecommerce.ui.mainactivity.MainRepository
import image.crystalapps.kecommerce.utils.FirebaseUtils
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList

class HomeViewModel @ViewModelInject constructor(private val mainRepository: MainRepository):
            BaseViewModel<HomeNavigator>(mainRepository) {

    val mUpdateEvent =MutableLiveData<Boolean>(false)

    val categoriesLiveData =MutableLiveData<List<Categories>>()
    val arrayList :ArrayList<Products> =ArrayList<Products>()






    fun setUpCategories(){
       val categoriesData = ArrayList<Categories>()
       categoriesData.add(Categories("Men",null))
       categoriesData.add(Categories("Women",null))
       categoriesLiveData.value=categoriesData }






   val allProductsLiveData =mUpdateEvent.switchMap {
       mainRepository.getAllProducts().distinctUntilChanged().switchMap {data->
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

    private fun filterData(data :Result<List<Products>>) :LiveData<List<Clothes>>{
        val result =MutableLiveData<List<Clothes>>()

        if (data is Result.Success){
            viewModelScope.launch {


                result.value =createClothList(data.data)
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