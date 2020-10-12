package image.crystalapps.ekommerceAdmin.ui.mainactivity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.SparseArray
import android.view.WindowManager
import android.widget.Toast
import androidx.core.util.forEach
import androidx.core.util.set
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupActionBarWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import image.crystalapps.ekommerceAdmin.BR
import image.crystalapps.ekommerceAdmin.R
import image.crystalapps.ekommerceAdmin.databinding.ActivityMainBinding
import image.crystalapps.ekommerceAdmin.ui.notification.SendNotification
import image.crystalapps.ekommercelibraries.ui.base.BaseActivity
import image.crystalapps.ekommercelibraries.viewmodel.ViewModelProviderFactory
import javax.inject.Inject
import kotlin.reflect.KClass


class MainActivity :  BaseActivity<MainViewModel, ActivityMainBinding>()   {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory



    private var currentNavController: LiveData<NavController>? = null

    private var mActivityMainBinding: ActivityMainBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN ,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        mActivityMainBinding = getViewDataBinding()
//
//        setUpLiveData()
//        setupDrawer()
        setupBottomNavigationBar()

    }


    private fun setupBottomNavigationBar() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_av)
        val navGraphId = listOf(R.navigation.home ,R.navigation.order ,R.navigation.home_navigation)

        val controller=   bottomNavigationView?.setupwithNavController(
            navGraphId = navGraphId,
            fragmentManager = supportFragmentManager,
            containerid = R.id.nav_host_container,
            intent = Intent()
        )



        currentNavController=controller

    }
    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false }


   private fun setUpLiveData(){
       getViewModel().getNavigateLiveData().observe(this ,navigateObserver) }


    private  val navigateObserver = Observer<KClass<out Activity>>{navigate->

        when(navigate){
         SendNotification::class ->{

             Toast.makeText(this ,"working " ,Toast.LENGTH_LONG).show();

        }

            else->{


            }
        }

    }








    override fun getBindingVariable(): Int {
      return  BR.viewModel }

    override fun getLayoutId(): Int {
  return R.layout.activity_main
    }

    override fun getViewModel(): MainViewModel {
        return  ViewModelProvider(this, viewModelProviderFactory).get(
            MainViewModel::class.java);
    }


////


    fun BottomNavigationView.setupwithNavController(

        navGraphId: List<Int>,
        fragmentManager: FragmentManager,
        containerid: Int,
        intent: Intent
    )
            : LiveData<NavController>
    {


        Log.i("test" ,"setupNavController ")
        // Map of tags
        val graphIdToTagMap = SparseArray<String>()


        // Result. Mutable live data with the selected controlled
        val selectedNavController = MutableLiveData<NavController>()

        var firstFragmentGraphId = 0



        // First create a NavHostFragment for each NavGraph ID
        navGraphId.forEachIndexed { index, navGraphId ->
            val fragmentTag = getFragmentTag(index)

            println("Nav Graph Id  $navGraphId")

            // Find or create the Navigation host fragment
            val navHostFragment = obtainNavHostFragment(
                fragmentManager,
                fragmentTag,
                navGraphId,
                containerid
            )

            // Obtain its id
            val graphId = navHostFragment.navController.graph.id

            Log.i("test" ,"graph id    $graphId")

            println("Graph id  $graphId")
            if (index == 0) {

                println("Firest Graph id $graphId")
                firstFragmentGraphId = graphId
            }

            // Save to the map
            graphIdToTagMap[graphId] = fragmentTag


            println("Selected Item id $selectedItemId")

            // Attach or detach nav host fragment depending on whether it's the selected item.
            if (this.selectedItemId == graphId) {

                println("Selected Item ${this.selectedItemId}")
                // Update livedata with the selected graph
                selectedNavController.value = navHostFragment.navController
                attachNavHostFragment(fragmentManager, navHostFragment, index == 0)
            } else {
                detachNavHostFragment(fragmentManager, navHostFragment)
            }
        }


                // Now connect selecting an item with swapping Fragments
                var selectedItemTag = graphIdToTagMap[this.selectedItemId]
                val firstFragmentTag = graphIdToTagMap[firstFragmentGraphId]
                var isOnFirstFragment = selectedItemTag == firstFragmentTag

                 //When a navigation item is selected
                setOnNavigationItemSelectedListener { item ->




                    // Don't do anything if the state is state has already been saved.
                    if (fragmentManager.isStateSaved) {
                        false
                    } else {
                        val newlySelectedItemTag = graphIdToTagMap[item.itemId]
                        if (selectedItemTag != newlySelectedItemTag) {
                            // Pop everything above the first fragment (the "fixed start destination")
                            fragmentManager.popBackStack(firstFragmentTag,
                                FragmentManager.POP_BACK_STACK_INCLUSIVE)
                            val selectedFragment = fragmentManager.findFragmentByTag(newlySelectedItemTag)
                                    as NavHostFragment

                            // Exclude the first fragment tag because it's always in the back stack.
                            if (firstFragmentTag != newlySelectedItemTag) {
                               //  Commit a transaction that cleans the back stack and adds the first fragment
                              //   to it, creating the fixed started destination.
                                fragmentManager.beginTransaction()
                                    .setCustomAnimations(
                                        R.anim.nav_default_enter_anim,
                                        R.anim.nav_default_exit_anim,
                                        R.anim.nav_default_pop_enter_anim,
                                        R.anim.nav_default_pop_exit_anim)
                                    .attach(selectedFragment)
                                    .setPrimaryNavigationFragment(selectedFragment)
                                    .apply {
                                        // Detach all other Fragments
                                        graphIdToTagMap.forEach { _, fragmentTagIter ->
                                            if (fragmentTagIter != newlySelectedItemTag) {
                                                detach(fragmentManager.findFragmentByTag(firstFragmentTag)!!)
                                            }
                                        }
                                    }
                                    .addToBackStack(firstFragmentTag)
                                    .setReorderingAllowed(true)
                                    .commit()
                            }
                            selectedItemTag = newlySelectedItemTag
                            isOnFirstFragment = selectedItemTag == firstFragmentTag
                            selectedNavController.value = selectedFragment.navController
                            true
                        } else {
                            false
                        }
            }
        }
//
//        // Optional: on item reselected, pop back stack to the destination of the graph
//        setupItemReselected(graphIdToTagMap, fragmentManager)
//
//        // Handle deep link
//        // setupDeepLinks(navGraphIds, fragmentManager, containerId, intent)
//
//        // Finally, ensure that we update our BottomNavigationView when the back stack changes
//        fragmentManager.addOnBackStackChangedListener {
//            if (!isOnFirstFragment && !fragmentManager.isOnBackStack(firstFragmentTag)) {
//                this.selectedItemId = firstFragmentGraphId
//            }
//
//            // Reset the graph if the currentDestination is not valid (happens when the back
//            // stack is popped after using the back button).
//            selectedNavController.value?.let { controller ->
//                if (controller.currentDestination == null) {
//                    controller.navigate(controller.graph.id)
//                }
//            }
//        }
        return selectedNavController

    }


    fun getFragmentTag(index: Int) = "bottomNavigation#$index"

    private fun obtainNavHostFragment(
        fragmentManager: FragmentManager,
        fragmentTag: String,
        navGraphId: Int,
        containerId: Int
    ): NavHostFragment {
        // If the Nav Host fragment exists, return it
        Log.i("test" ,"Working")
        val existingFragment = fragmentManager.findFragmentByTag(fragmentTag) as NavHostFragment?
        existingFragment?.let { return it }
       // println("existing   $existingFragment")
        // Otherwise, create it and return it.
        val navHostFragment = NavHostFragment.create(navGraphId)
        fragmentManager.beginTransaction()
            .add(containerId, navHostFragment, fragmentTag)
            .commitNow()
        return navHostFragment
    }






    private fun BottomNavigationView.setupItemReselected(
        graphIdToTagMap: SparseArray<String>,
        fragmentManager: FragmentManager
    ) {
        setOnNavigationItemReselectedListener { item ->
            val newlySelectedItemTag = graphIdToTagMap[item.itemId]
            val selectedFragment = fragmentManager.findFragmentByTag(newlySelectedItemTag)
                    as NavHostFragment
            val navController = selectedFragment.navController
            // Pop the back stack to the start destination of the current navController graph
            navController.popBackStack(
                navController.graph.startDestination, false
            )
        }
    }

    private fun detachNavHostFragment(
        fragmentManager: FragmentManager,
        navHostFragment: NavHostFragment
    ) {
        fragmentManager.beginTransaction()
            .detach(navHostFragment)
            .commitNow()
    }



    private fun attachNavHostFragment(
        fragmentManager: FragmentManager,
        navHostFragment: NavHostFragment,
        isPrimaryNavFragment: Boolean
    ) {
        fragmentManager.beginTransaction()
            .attach(navHostFragment)
            .apply {
                if (isPrimaryNavFragment) {
                    setPrimaryNavigationFragment(navHostFragment)
                }
            }
            .commitNow()

    }



    private fun FragmentManager.isOnBackStack(backStackName: String): Boolean {
        val backStackCount = backStackEntryCount
        for (index in 0 until backStackCount) {
            if (getBackStackEntryAt(index).name == backStackName) {
                return true
            }
        }
        return false
    }




}
