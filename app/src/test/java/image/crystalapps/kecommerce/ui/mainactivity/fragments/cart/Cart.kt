package image.crystalapps.kecommerce.ui.mainactivity.fragments.carttest

import android.view.View
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.BoundedMatcher
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.ext.launchFragmentInHiltContainer
import image.crystalapps.kecommerce.ui.mainactivity.fragments.cart.Cart
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class Cart {

    @get:Rule
    val hiltRule= HiltAndroidRule(this)

    @Before
    fun initDataManager(){
        hiltRule.inject()
    }


    @Test
    fun  startActivity_CheckParcelIntent(){
        launchFragmentInHiltContainer<Cart>()


    }
//
//    fun atPosition(position: Int, itemMatcher: Matcher<View?>): Matcher<View?>? {
//
//        return object : BoundedMatcher<View?, RecyclerView>(RecyclerView::class.java) {
//            override fun describeTo(description: Description) {
//                description.appendText("has item at position $position: ")
//                itemMatcher.describeTo(description)
//            }
//
//            override fun matchesSafely(view: RecyclerView): Boolean {
//                val viewHolder =
//                    view.findViewHolderForAdapterPosition(position)
//                        ?: // has no item on such position
//                        return false
//                return itemMatcher.matches(viewHolder.itemView)
//            }
//        }
//    }
}