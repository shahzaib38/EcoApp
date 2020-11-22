package image.crystalapps.kecommerce.ui.mainactivity

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers

class ViewMatchers {




    companion object {

        fun atPosition(position: Int, item: Matcher<View>): Matcher<View> {


            return object : BoundedMatcher<View, RecyclerView>(RecyclerView::class.java) {
                override fun describeTo(description: Description?) {}

                override fun matchesSafely(recyclerView: RecyclerView?): Boolean {

                    val recyclerViewHolder =
                        recyclerView?.findViewHolderForAdapterPosition(position)
                    if (recyclerViewHolder == null) return false



                    return item.matches(recyclerViewHolder.itemView)

                }

            }
        }


        fun withText(subString: String): Matcher<View> {
            return returnText(Matchers.`is`(subString))
        }


        private fun returnText(stringMatcher :Matcher<String>):Matcher<View>{
            return object : BoundedMatcher<View ,TextView>(TextView::class.java){
                override fun describeTo(description: Description?) {}

                override fun matchesSafely(item: TextView?): Boolean {
                    val withText=  item?.text
                    return      stringMatcher.matches(withText)
                } }
        }

    }





}