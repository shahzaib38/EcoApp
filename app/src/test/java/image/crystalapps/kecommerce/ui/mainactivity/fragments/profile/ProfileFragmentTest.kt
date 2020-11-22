package image.crystalapps.kecommerce.ui.mainactivity.fragments.profile

import androidx.test.ext.junit.runners.AndroidJUnit4
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import image.crystalapps.kecommerce.ext.launchFragmentInHiltContainer
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class ProfileFragmentTest {




    @get:Rule
    val hiltRule= HiltAndroidRule(this)

    @Before
    fun initTest(){
        hiltRule.inject() }



    @Test
    fun checkProfileButton(){
        launchFragmentInHiltContainer<Profile>()

    }



}