package image.crystalapps.kecommerce.ui.productselection

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class ProductViewModel @ViewModelInject constructor(private val productRespository: ProductRepository) :
    BaseViewModel<SelectionNavigator>(productRespository) {



//    fun getCurrentRepositoryData() : LiveData<PagingData<Products>> {
//        return productRespository.getSearchResult() }


    fun addToCart(){
    getNavigator().addToCart()





        fun favourite(){
            getNavigator().favourite() }




















    }

    fun addToCart(product: Cart) {

//        viewModelScope.launch {
//            dataManager.addToCart(product)
//        }

        }


}