package image.crystalapps.kecommerce.ui.mainactivity.fragments.categories

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import image.crystalapps.kecommerce.data.DataManager
import image.crystalapps.kecommerce.model.Categories
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.ui.base.BaseViewModel
import image.crystalapps.kecommerce.ui.mainactivity.MainRepository
import javax.inject.Inject

class CategoriesViewModel  @ViewModelInject constructor(val mainRepository : MainRepository):
    BaseViewModel<CategoriesNavigator>(mainRepository) {

    val categoriesLiveData = MutableLiveData<List<Categories>>()
    val arrayList :ArrayList<Products> =ArrayList<Products>()




    fun setUpCategories(){
        val categoriesData = ArrayList<Categories>()
        categoriesData.add(Categories("Men",null))
        categoriesData.add(Categories("Women",null))
        categoriesData.add(Categories("Kids",null))

        categoriesLiveData.value=categoriesData }
}