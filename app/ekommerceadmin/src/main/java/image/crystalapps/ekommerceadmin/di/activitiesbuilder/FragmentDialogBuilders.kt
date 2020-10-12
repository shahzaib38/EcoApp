package image.crystalapps.ekommerceadmin.di.activitiesbuilder

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentDialogBuilders {




    @ContributesAndroidInjector(modules = arrayOf(FragmentViewModel::class ,FirebaseSignInModule::class))
    abstract fun contributeMainDialogFragmeet() :MainDialogFragment






}