package image.crystalapps.kecommerce.di.activitiesbuilder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import image.crystala.MainActivity
import image.crystalapps.kecommerce.ui.clothes.ClothesActivity
import image.crystalapps.kecommerce.ui.clothes.ClothesViewModelModule
import image.crystalapps.kecommerce.ui.filter.FilterActivity
import image.crystalapps.kecommerce.ui.filter.FilterViewModelModule

import image.crystalapps.kecommerce.ui.mainactivity.MainViewModelProvider
import image.crystalapps.kecommerce.ui.productselection.ProductSelectionActivity
import image.crystalapps.kecommerce.ui.productselection.ProductViewModel
import image.crystalapps.kecommerce.ui.productselection.ProductViewModelModule


@Module
abstract class ActivityBuilderModule {


    @ContributesAndroidInjector(modules = [MainViewModelProvider::class, FragmentBuilders::class, FragmentDialogBuilders::class])
    abstract fun contributeMainActivity(): MainActivity


    @ContributesAndroidInjector(modules = [ClothesViewModelModule::class ,ProductFragmentDialogBuilder::class])
    abstract fun contributeClothesActivity():ClothesActivity

    @ContributesAndroidInjector(modules = [ProductViewModelModule::class ])
    abstract fun contributeProductSelectionActivity():ProductSelectionActivity


    @ContributesAndroidInjector(modules = [FilterViewModelModule::class ])
    abstract fun contributeFilterActivity():FilterActivity


}