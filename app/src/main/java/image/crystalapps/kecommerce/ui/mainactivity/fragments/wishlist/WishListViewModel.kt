package image.crystalapps.kecommerce.ui.mainactivity.fragments.wishlist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.model.WishModel
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.ui.mainactivity.MainRepository
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.launch

class WishListViewModel @ViewModelInject constructor(val mainRepository: MainRepository):
    BaseViewModel<WishListNavigator>(mainRepository) {


    fun insertWish(wishModel: WishModel){
    //    mainRepository.insertWish(wishModel)

    }

    val mUpdateEvent =MutableLiveData<Boolean>(false)


//    val allCartLiveDataManager =mUpdateEvent.switchMap {
//        mainRepository.getWishList().distinctUntilChanged().switchMap {data->
//            filterData(data)
//        }}


    private fun filterData(data : Result<List<WishModel>>) : LiveData<List<WishModel>> {
        val result = MutableLiveData<List<WishModel>>()
        if (data is Result.Success){
            viewModelScope.launch {
                result.value=data.data } }
        if(data is Result.Error){
            println("Error is cominng") }
        return result }






}