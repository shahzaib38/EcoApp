package image.crystalapps.kecommerce.ui.productselection

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.viewModelScope
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.Cart
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class ProductViewModel @ViewModelInject constructor(private val dataManager: DataManager) :
    BaseViewModel<SelectionNavigator>(dataManager) {




    fun addToCart(){
    getNavigator().addToCart()

    }

    fun addToCart(product: Cart) {

        viewModelScope.launch {
            dataManager.addToCart(product)
        }

        }


}