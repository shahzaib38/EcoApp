package image.crystalapps.kecommerce.ui.mainactivity.fragments.cart

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.ui.mainactivity.MainRepository
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.launch

class CartViewModel @ViewModelInject constructor(val mainRepository : MainRepository):
    BaseViewModel<CartNavigator>(mainRepository){



    val mUpdateEvent =MutableLiveData<Boolean>(false)

    val _TotalText =MutableLiveData<String>()
    val totalText =_TotalText

    val _TotalItems =MutableLiveData<Int>()
    val totalItems =_TotalItems


    val allCartLiveDataManager =mUpdateEvent.switchMap {
        mainRepository.getCartItem().distinctUntilChanged().switchMap {data->
            filterData(data)
        }}


    fun increment(cart :Cart){
        mainRepository.addToCart(cart) }

    fun decrement(cart :Cart){
        mainRepository.decrement(cart) }

    fun checkOut(){
        getNavigator().checkOut() }


    fun setTotalPrice(totalPrice :String){
        _TotalText.value=totalPrice }

    fun setItems(totalItems : Int){
        _TotalItems.value =totalItems }

    private  fun delete(cart: Cart){}

    private fun filterData(data : Result<List<Cart>>) : LiveData<List<Cart>> {
        val result = MutableLiveData<List<Cart>>()
        if (data is Result.Success){
            viewModelScope.launch {
                result.value=data.data } }
        if(data is Result.Error){
            println("Error is cominng") }
        return result }


}