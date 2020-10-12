package image.crystalapps.ekommerceAdmin.ui.notification

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import image.crystalapps.ekommerceAdmin.di.activitiesbuilder.ViewModelKey

@Module
abstract class SendNotificationViewModelModule {



    @ViewModelKey(SendNotificationViewModel::class)
    @IntoMap
    @Binds
    abstract fun provideMainViewModel(mainViewModel: SendNotificationViewModel): ViewModel


}