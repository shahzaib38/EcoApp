package image.crystalapps.kecommerce.ui.mainactivity.fragments.products

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.*
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.Categories
import image.crystalapps.kecommerce.model.Clothes
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.pagination.FireStorePagingSource
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.ui.mainactivity.MainRepository
import image.crystalapps.kecommerce.utils.FirebaseUtils
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import kotlinx.coroutines.withContext
import java.util.concurrent.Callable

class BlogViewModel  @ViewModelInject  constructor(val mainRepository: MainRepository) :BaseViewModel<BlogNavigator>(mainRepository ) {




    val mUpdateEvent = MutableLiveData<Boolean>(false)

    val mUpdateEvent1 = MutableLiveData<Boolean>(false)

    val pagingFlowData =MutableLiveData<PagingData<Products>>()


    val categoriesLiveData = MutableLiveData<List<Categories>>()
    val arrayList :ArrayList<Products> =ArrayList<Products>()







   suspend fun getFireStoreResult()
       {
           mainRepository.getFireStoreResult().onEach {

        //       pagingFlowData.value =it


           }.flowOn(Dispatchers.IO
           )
               .launchIn(viewModelScope + Dispatchers.IO)



       }

//
//        Pager(PagingConfig(20)) {
//            FireStorePagingSource()
//        }.flow.cachedIn(viewModelScope)


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