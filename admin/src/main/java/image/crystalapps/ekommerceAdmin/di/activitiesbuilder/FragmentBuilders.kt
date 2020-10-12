package image.crystalapps.ekommerceAdmin.di.activitiesbuilder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import image.crystalapps.ekommerceAdmin.ui.mainactivity.fragments.home.Home
import image.crystalapps.ekommerceAdmin.ui.mainactivity.fragments.home.HomeViewModelModule
import image.crystalapps.ekommerceAdmin.ui.menfashion.MenFashion
import image.crystalapps.ekommerceAdmin.ui.menfashion.MenFashionViewModelModule

@Module
abstract class FragmentBuilders {

//
//    @ContributesAndroidInjector
//    abstract fun getTabFragment() :TabFragment


    @ContributesAndroidInjector(modules = [HomeViewModelModule::class])
    abstract fun contributeHomeFragment() : Home


    @ContributesAndroidInjector(modules = [MenFashionViewModelModule::class])
     abstract fun contributeMenFashionFragment()  : MenFashion
//
//    @ContributesAndroidInjector(modules = [MenListViewModelModule::class])
//    abstract fun contributeMenListFashionFragment() :MenList
////


}