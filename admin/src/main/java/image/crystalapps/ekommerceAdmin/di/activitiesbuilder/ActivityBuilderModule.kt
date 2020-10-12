package image.crystalapps.ekommerceAdmin.di.activitiesbuilder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import image.crystalapps.ekommerceAdmin.ui.firebasedemo.*
import image.crystalapps.ekommerceAdmin.ui.mainactivity.MainActivity
import image.crystalapps.ekommerceAdmin.ui.mainactivity.MainViewModelProvider
import image.crystalapps.ekommerceAdmin.ui.menfashion.MenFashion
import image.crystalapps.ekommerceAdmin.ui.menfashion.MenFashionViewModelModule
import image.crystalapps.ekommerceAdmin.ui.menfashionlist.MenFashionList
import image.crystalapps.ekommerceAdmin.ui.menfashionlist.MenFashionListAdapterModule
import image.crystalapps.ekommerceAdmin.ui.menfashionlist.MenFashionListViewModelModule
import image.crystalapps.ekommerceAdmin.ui.notification.SendNotification
import image.crystalapps.ekommerceAdmin.ui.notification.SendNotificationViewModelModule
import image.crystalapps.ekommerceAdmin.ui.womenfashion.WomenFashion
import image.crystalapps.ekommerceAdmin.ui.womenfashion.WomenFashionViewModelModule
import image.crystalapps.ekommerceAdmin.ui.womenfashionlist.WomenFashionList
import image.crystalapps.ekommerceAdmin.ui.womenfashionlist.WomenFashionListViewModelModule


@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainViewModelProvider::class, FragmentBuilders::class, FragmentDialogBuilders::class])
    abstract fun contributeMainActivity(): MainActivity
//
//    @ContributesAndroidInjector(modules = [MenFashionListViewModelModule::class , MenFashionListAdapterModule::class])
//    abstract fun contributeMenListFashionActivity()  :MenFashionList
//
//
//    @ContributesAndroidInjector(modules = [MenFashionViewModelModule::class])
//    abstract fun contributeMenFashionActivity() :MenFashion
//
//
//    @ContributesAndroidInjector(modules = [WomenFashionViewModelModule::class])
//    abstract fun contributeWomenFashionActivity() :WomenFashion
//
//    @ContributesAndroidInjector(modules = [WomenFashionListViewModelModule::class])
//    abstract fun contributeWomenFashionListActivity() :WomenFashionList
//
//    @ContributesAndroidInjector(modules = [SendNotificationViewModelModule::class])
//    abstract fun contributeSendNotificationActivity(): SendNotification
//
//
//    @ContributesAndroidInjector(modules = [FirebaseViewModelModule::class])
//    abstract fun contributeActivity2Main() :ActivityMain
//
//    @ContributesAndroidInjector(modules = [RestaurantViewModelModule::class])
//    abstract fun contributeRestaurantActivity() :RestaurantDetails
//
//

}
