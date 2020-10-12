package image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.networkconnection

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.kecommerce.di.activitiesbuilder.ViewModelKey

@Module
abstract class InternetViewModelModule {


    @IntoMap
    @ViewModelKey(InternetViewModel::class)
    @Binds
    abstract fun bindInternetViewModel(internetViewModel: InternetViewModel): ViewModel


}

