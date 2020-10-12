package image.crystalapps.kecommerce.ui.productselection

import androidx.lifecycle.viewModelScope
import image.crystalapps.Products
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import image.crystalapps.kecommerce.data.DataManager
import kotlinx.coroutines.launch
import javax.inject.Inject

class ProductViewModel @Inject constructor(private val dataManager: DataManager) :BaseViewModel<SelectionNavigator>(dataManager) {




    fun addToCart(){
    getNavigator().addToCart()

    }

    fun addToCart(product: Products) {

        viewModelScope.launch {
            dataManager.addToCart(product)
        }

        }


}