package image.crystalapps.ekommerceadmin.di.activitiesbuilder

import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilders {


    @ContributesAndroidInjector
    abstract fun getMainFragment() :MainFragment




}