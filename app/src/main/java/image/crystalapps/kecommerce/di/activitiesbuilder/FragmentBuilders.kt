package image.crystalapps.kecommerce.di.activitiesbuilder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import image.crystalapps.kecommerce.ui.mainactivity.MainFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.cart.Cart
import image.crystalapps.kecommerce.ui.mainactivity.fragments.cart.CartViewModelModule
import image.crystalapps.kecommerce.ui.mainactivity.fragments.categories.Categories
import image.crystalapps.kecommerce.ui.mainactivity.fragments.categories.CategoriesViewModel
import image.crystalapps.kecommerce.ui.mainactivity.fragments.categories.CategoriesViewModelModule
import image.crystalapps.kecommerce.ui.mainactivity.fragments.home.Home
import image.crystalapps.kecommerce.ui.mainactivity.fragments.home.HomeViewModelModule
import image.crystalapps.kecommerce.ui.mainactivity.fragments.order.Order
import image.crystalapps.kecommerce.ui.mainactivity.fragments.order.OrderViewModel
import image.crystalapps.kecommerce.ui.mainactivity.fragments.order.OrderViewModelModule
import image.crystalapps.kecommerce.ui.mainactivity.fragments.signout.SignOut
import image.crystalapps.kecommerce.ui.mainactivity.fragments.signout.SignOutViewModelModule
import image.crystalapps.kecommerce.ui.mainactivity.fragments.wishlist.WishList
import image.crystalapps.kecommerce.ui.mainactivity.fragments.wishlist.WishListViewModelModule

@Module
abstract class FragmentBuilders {


    @ContributesAndroidInjector(modules = [TabViewModel::class])
    abstract fun contributeMainFragment() :MainFragment

    @ContributesAndroidInjector(modules = [HomeViewModelModule::class])
    abstract fun contributeHomeFragment() :Home

    @ContributesAndroidInjector(modules = [CartViewModelModule::class])
    abstract fun contributeCartFragment() : Cart

    @ContributesAndroidInjector(modules = [OrderViewModelModule::class])
    abstract fun contributeOrderFragment():Order

    @ContributesAndroidInjector(modules = [CategoriesViewModelModule::class])
    abstract fun contributeCategoriesFragment() :Categories

    @ContributesAndroidInjector(modules = [WishListViewModelModule::class])
    abstract fun contributeWishListFragment() :WishList

    @ContributesAndroidInjector(modules = [SignOutViewModelModule::class])
    abstract  fun contributeSignOutFragment() :SignOut






}