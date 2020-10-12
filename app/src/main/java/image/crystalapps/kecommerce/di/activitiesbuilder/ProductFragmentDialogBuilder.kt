package image.crystalapps.kecommerce.di.activitiesbuilder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import image.crystalapps.kecommerce.ui.productselection.dialogfragment.FilterDialogFragment
import image.crystalapps.kecommerce.ui.productselection.dialogfragment.FilterViewModelModule
import image.crystalapps.kecommerce.ui.productselection.varieties.VarietiesDialog
import image.crystalapps.kecommerce.ui.productselection.varieties.VarietiesViewModelModule

@Module
abstract class ProductFragmentDialogBuilder {

    @ContributesAndroidInjector(modules = [VarietiesViewModelModule::class])
    abstract  fun contributeVarietiesDialogFragment() : VarietiesDialog


    @FragmentScope
    @ContributesAndroidInjector(modules = [FilterViewModelModule::class])
    abstract  fun contributeFilteraaDialogFragment() : FilterDialogFragment


}