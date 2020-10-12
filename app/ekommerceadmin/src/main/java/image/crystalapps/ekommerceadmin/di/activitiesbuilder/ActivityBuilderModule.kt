package image.crystalapps.ekommerceadmin.di.activitiesbuilder

import dagger.Module
import dagger.android.ContributesAndroidInjector


@Module
abstract class ActivityBuilderModule {


    @ContributesAndroidInjector(modules = arrayOf(MainViewModelProvider::class ,FragmentBuilders::class ,FragmentDialogBuilders::class))
    abstract fun contributeMainActivity(): MainActivity



}
