package image.crystalapps.kecommerce.ui.mainactivity.fragments.home


import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.MediumTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


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
    fun checkHomeFragment_DetailIsDisplayed(){
//        launchFragmentInHiltContainer<Home>()
//        onView(withId(R.id.imageView3)).check(matches(isDisplayed()))
//
//        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.scrollTo<BaseViewHolder<CartItemDataBinding>>(
//            hasDescendant(withText("White"))))

    }




    @After
  fun  removeDataManager(){
    }







}