package image.crystalapps.kecommerce.ui.mainactivity.fragments.cart

import android.content.ClipData
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.utils.Result
import kotlinx.coroutines.launch
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap

class CartViewModel @ViewModelInject constructor(val dataManager: DataManager):
    BaseViewModel<CartNavigator>(dataManager){


    var total =0

    val mUpdateEvent =MutableLiveData<Boolean>(false)

    val items =ArrayList<Cart>()

    val _sumUp =MutableLiveData<Int>()

    val sumUp=_sumUp

    val allCartLiveDataManager =mUpdateEvent.switchMap {
        dataManager.getCartItem().distinctUntilChanged().switchMap {data->
            filterData(data) } }


    fun increment(cart :Cart){
        dataManager.addToCart(cart)
        println("Incrementing ${cart.qty}")
    }

    fun decrement(cart :Cart){
        dataManager.decrement(cart)
        println("Incrementing ${cart.qty}")
    }

    fun checkOut(){

        getNavigator().checkOut(total ,items)
    }

   private fun add(cart :Cart){
       items.add(cart)
       for( item in items){

      val   products=  item.products
           if(products!=null) {
               total = products.productPrice * item.qty


           }else throw NullPointerException("Product is Null")
       }
       _sumUp.value=total


   }
   private  fun delete(cart: Cart){
       items.remove(cart)
       if(items.isNotEmpty()){
           for( item in items){

               val   products=  item.products
               if(products!=null) {
                   total = products.productPrice * item.qty


               }else throw NullPointerException("Product is Null")
           }
           _sumUp.value=total
       }else{
           sumUp.value=0
       }

   }

    fun onCheckedChanged(cart: Cart , isChecked :Boolean){

        if(isChecked){
            add(cart)
        }else{
            delete(cart)
        }


    }








    private fun filterData(data : Result<List<Cart>>) : LiveData<List<Cart>> {
        val result = MutableLiveData<List<Cart>>()

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