package image.crystalapps.kecommerce.ui.mainactivity.fragments.categories

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.kecommerce.di.activitiesbuilder.ViewModelKey
import image.crystalapps.kecommerce.ui.mainactivity.fragments.home.HomeViewModel


@Module
abstract class CategoriesViewModelModule {

    @IntoMap
    @ViewModelKey(CategoriesViewModel::class)
    @Binds
    abstract fun bindCategoriesFragmentViewModel(categoriesViewModel : CategoriesViewModel): ViewModel



}