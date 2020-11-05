package image.crystalapps.kecommerce.ui.mainactivity.dialogfragment

import androidx.fragment.app.testing.launchFragment
import androidx.test.espresso.matcher.ViewMatchers.assertThat
import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import image.crystalapps.kecommerce.ext.launchFragmentInHiltContainer
import image.crystalapps.kecommerce.ui.mainactivity.fragments.dialogfragments.networkconnection.InternetManagerDialogFragment
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class InternetConnectionTest {

    @get:Rule
    val hiltRule= HiltAndroidRule(this)

    @Before
    fun initDataManager(){
        hiltRule.inject() }



    @Test
    fun  internetConnectionDialog_check(){
//
//
//        with(launchFragment<InternetManagerDialogFragment>()){
//
//            onFragment {fragment ->
//                assertThat(fragment.dialog).isNotNull()
//
//
//
//            }

        launchFragmentInHiltContainer<InternetManagerDialogFragment> {  }


        }





}