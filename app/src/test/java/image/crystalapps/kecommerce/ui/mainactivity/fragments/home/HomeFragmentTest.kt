package image.crystalapps.kecommerce.ui.mainactivity.fragments.home


import android.view.View
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.ext.launchFragmentInHiltContainer
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.ui.mainactivity.fragments.popular.PopularFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.products.BlogFragment
import image.crystalapps.kecommerce.ui.mainactivity.fragments.recent.RecentProducts
import kotlinx.android.synthetic.main.fragment_home.*
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Assert.*


@MediumTest
@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class HomeFragmentTest{


    @get:Rule
  val hiltRule=HiltAndroidRule(this)

    @Before
    fun initDataManager(){
        hiltRule.inject() }

  @Test
  fun shouldShowLatestArrivalFragment(){
    launchFragmentInHiltContainer<Home>{
      assertTrue(this.childFragmentManager.findFragmentById(R.id.recentContainer) is RecentProducts) } }

  @Test
  fun shouldShowPopularFragment(){
    launchFragmentInHiltContainer<Home>{
      assertTrue(this.childFragmentManager.findFragmentById(R.id.popularContainer) is PopularFragment) } }

  @Test
  fun shouldShowBlogFragment(){
    launchFragmentInHiltContainer<Home>{
      assertTrue(this.childFragmentManager.findFragmentById(R.id.blogContainer) is BlogFragment) } }


    @Test
    fun showShowRecentFragmentWhenVisibilityIsTrue(){
      launchFragmentInHiltContainer<Home> {
     val fragment= this.childFragmentManager.findFragmentById(R.id.recentContainer) as RecentProducts
        fragment.visibilityListener?.changeVisibility(true)
        assertEquals(View.VISIBLE ,this.recentContainer.visibility)
      } }

  @Test
  fun shouldShowPopularFragmentWhenVisibilityIsTrue(){
    launchFragmentInHiltContainer<PopularFragment> {
      val fragment = this.childFragmentManager.findFragmentById(R.id.popularContainer)  as PopularFragment
      fragment.visibilityListener?.changeVisibility(true)
      assertEquals(View.VISIBLE, this.popularContainer.visibility) } }

  @Test
  fun shouldShowBlogFragmentWhenVisibilityIsTrue(){
    launchFragmentInHiltContainer<Home> {
      val fragment = this.childFragmentManager.findFragmentById(R.id.blogContainer)  as BlogFragment
      fragment.visibilityListener?.changeVisibility(true)
      assertEquals(View.VISIBLE, this.blogContainer.visibility)
    }}




  @Test
  fun showHideRecentFragmentWhenVisibilityIsTrue(){
    launchFragmentInHiltContainer<Home> {
      val fragment= this.childFragmentManager.findFragmentById(R.id.recentContainer) as RecentProducts
      fragment.visibilityListener?.changeVisibility(false)
      assertEquals(View.GONE , this.recentContainer.visibility) }}



  @Test
  fun shouldHidePopularFragmentWhenVisibilityIsTrue(){
    launchFragmentInHiltContainer<Home> {
      val fragment = this.childFragmentManager.findFragmentById(R.id.popularContainer)  as PopularFragment
      fragment.visibilityListener?.changeVisibility(false)
      assertEquals(View.GONE ,this.popularContainer.visibility)
    }
  }


  @Test
  fun shouldHideBlogFragmentWhenVisibilityIsTrue(){
    launchFragmentInHiltContainer<Home> {
      val fragment = this.childFragmentManager.findFragmentById(R.id.blogContainer)  as BlogFragment
      fragment.visibilityListener?.changeVisibility(false)
      assertEquals(View.GONE, this.blogContainer.visibility)
    }}









  @After
  fun  removeDataManager(){

  }







}