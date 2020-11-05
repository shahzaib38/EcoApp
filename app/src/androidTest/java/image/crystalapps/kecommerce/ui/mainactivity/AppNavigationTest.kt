package image.crystalapps.kecommerce.ui.mainactivity

import android.view.Gravity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions.open
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.contrib.NavigationViewActions.navigateTo
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import image.crystala.MainActivity
import image.crystalapps.kecommerce.R
import org.hamcrest.Matchers.containsString
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
@LargeTest

class AppNavigationTest {


    @get:Rule
    val hiltRule= HiltAndroidRule(this)

    @Before
    fun beforeAppNavigate(){
        hiltRule.inject() }



    @Test
    fun drawerNavigationTest(){

        // Activity Scenerio
        val mainActivityScenario= ActivityScenario.launch(MainActivity::class.java)

        //Check If Closed then Open It
        onView(withId(R.id.drawer_layout)).check(matches(isClosed(Gravity.START))).perform(open())

        //Navigate To Profile Fragment
        onView(withId(R.id.navigationView)).perform(navigateTo(
            R.id.profile_fragment
        ))

        //Check if Profile fragment Circle ImageView is Displayed
        onView((withId(R.id.circleImageView))).check(matches(isDisplayed()))

//        onView(withId(R.id.drawer_layout)).check(matches(isClosed(Gravity.START))).perform(open())

        onView(withId(R.id.navigationView)).perform(navigateTo(R.id.cart))

        mainActivityScenario.close()

    }


    @Test
    fun mainActivity_UserProfileTest(){
        val mainActivityScenario= ActivityScenario.launch(MainActivity::class.java)

//        onView(withId(R.id.profile_text)).check(matches(ViewMatchers.withText("")))


    }

    @Test
    fun mainActivity_RecycylerViewTest(){
        val mainActivityScenario= ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.recycler_view))
            .check(matches(ViewMatchers.atPosition(1, hasDescendant(withText("White")))));
    }

    
    
//    @Test
//    fun homeScreen_clickOnAndroidHamburger_OpenNavigation(){
//        val ActivityScenario =ActivityScenario.launch(MainActivity::class.java)
//
//        onView(withId(R.id.drawer_layout)).check(matches(isClosed(Gravity.START))).perform(open())
//    }
//
//
//
//
//    @Test
//    fun homeScreenRecyclerView_checkTextExistOrNot(){
//
//        onView(withId(R.id.recycler_view)).perform(RecyclerViewActions.scrollTo<RecyclerView.ViewHolder>
//            (ViewMatchers.hasDescendant(ViewMatchers.withText("Black T Shirt"))))
//
//
//
//
//    }




}