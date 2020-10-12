package image.crystalapps.kecommerce.di.activitiesbuilder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.LogInDialogFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.LogInViewModelModule
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.networkconnection.InternetManagerDialogFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.networkconnection.InternetViewModelModule
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.signout.SignOutDialogFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.signout.SignOutViewModelModule

@Module
abstract class FragmentDialogBuilders {


    @ContributesAndroidInjector(modules = [LogInViewModelModule::class])
    abstract fun contributeFirebaseAuthenticationDialogFragment() :LogInDialogFragment


    @ContributesAndroidInjector(modules = [SignOutViewModelModule::class])
          abstract fun contributeLoginViewModelModuleDialogFragment() :SignOutDialogFragment


    @ContributesAndroidInjector(modules = [InternetViewModelModule::class])
    abstract  fun contributeInternetDialogFragment() :InternetManagerDialogFragment

}