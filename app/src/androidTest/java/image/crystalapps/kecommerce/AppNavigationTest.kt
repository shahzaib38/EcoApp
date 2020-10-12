package image.crystalapps.kecommerce

import android.view.Gravity
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.DrawerActions.open
import androidx.test.espresso.contrib.DrawerMatchers.isClosed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import image.crystala.MainActivity
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class AppNavigationTest {


    @Test
    fun drawerNavigationTest(){
    val mainActivityScenario= ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.drawer_layout)).check(matches(isClosed(Gravity.START))).perform(open())

        mainActivityScenario.close()

    }


}