package image.crystala


import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import javax.inject.Inject
import androidx.navigation.NavController
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.data.database.prefs.SaveTokenSharedPreferenceHelper
import image.crystalapps.kecommerce.data.database.prefs.SharedPreferenceEntry
import image.crystalapps.kecommerce.databinding.MainDataBinding
import image.crystalapps.kecommerce.databinding.setProfileContent
import image.crystalapps.kecommerce.databinding.snackBarSetup
import image.crystalapps.kecommerce.model.*
import image.crystalapps.kecommerce.ui.base.BaseActivity
import image.crystalapps.kecommerce.ui.mainactivity.MainViewModel
import kotlinx.android.synthetic.main.drawerappbar.*


@AndroidEntryPoint
class MainActivity : BaseActivity<MainViewModel, MainDataBinding>(){

    @Inject
    lateinit var   mSaveTokenSharedPreferenceHelper : SaveTokenSharedPreferenceHelper

    private lateinit var mDrawer: DrawerLayout
    private var mActivityMainBinding: MainDataBinding? = null
    private lateinit var appBarConfiguration: AppBarConfiguration
     private  lateinit var mSharedPreferenceEntry:SharedPreferenceEntry

    private val mViewModel by viewModels<MainViewModel>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          mActivityMainBinding = getViewDataBinding()
          window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
              WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setSupportActionBar(findViewById(R.id.toolbar))
        setupNavigationDrawer()
        setUpNavigationComponent()
        mSharedPreferenceEntry = mSaveTokenSharedPreferenceHelper.getTokenInformation()
        setUpUi()

    }


  private fun setUpUi(){
      mActivityMainBinding?.root?.
          snackBarSetup(this,
              getViewModel().snackBarText , Snackbar.LENGTH_LONG)

      mViewModel.getUserProfile().observe(this, Observer {firebaseUser->
          mActivityMainBinding?.run { this.root.setProfileContent(firebaseUser) } })


    //  setData()
  }

    //Navigation Functions
    private fun setUpNavigationComponent(){
        val navController: NavController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration =AppBarConfiguration(navController.graph,mDrawer)

        setupActionBarWithNavController(navController, appBarConfiguration)

        findViewById<NavigationView>(R.id.navigationView)
            .setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration) ||
                super.onSupportNavigateUp() }
    private  fun setupNavigationDrawer(){
        mDrawer =(findViewById<DrawerLayout>(R.id.drawer_layout))
            .apply {
                setStatusBarBackground(R.color.colorPrimaryDark)
            }

    }

    // DrawerLayout Functions
    private fun UnlockDrawer(){
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED) }
    override fun onResume() {
        super.onResume()
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        checkAuthentication()


    }
    fun checkAuthentication(){
      val mGoogleAuthentication=  Firebase.auth
        getViewModel().checkGoogleAuthentication(mSharedPreferenceEntry.token,mGoogleAuthentication)

    }
    private fun LockDrawer(){
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED)
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_main }
    override fun getViewModel(): MainViewModel =mViewModel

    override fun getBindingVariable(): Int {
        return BR.viewModel}
    fun setGoogleAuth(firebaseAuth: FirebaseAuth?) {
        getViewModel().checkGoogleAuthentication(mSharedPreferenceEntry.token ,firebaseAuth) }
    override fun onStart() {
        super.onStart()
        getViewModel().checkGoogleAuthentication( mSharedPreferenceEntry.token,Firebase.auth)
    }

}