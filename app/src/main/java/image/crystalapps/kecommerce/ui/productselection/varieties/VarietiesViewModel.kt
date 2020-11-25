package image.crystalapps.kecommerce.ui.productselection.varieties

import androidx.hilt.lifecycle.ViewModelInject
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.ui.productselection.ProductRepository
import javax.inject.Inject

class VarietiesViewModel @ViewModelInject constructor(private val productRepository: ProductRepository) :
    BaseViewModel<VarietiesNavigator>(productRepository) {




}