package image.crystala


import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import image.crystalapps.ekommercelibraries.ui.base.BaseActivity
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.viewmodel.ViewModelProviderFactory
import javax.inject.Inject



import androidx.navigation.NavController
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import image.crystalapps.Products
import image.crystalapps.kecommerce.data.database.prefs.SaveTokenSharedPreferenceHelper
import image.crystalapps.kecommerce.data.database.prefs.SharedPreferenceEntry
import image.crystalapps.kecommerce.databinding.MainDataBinding
import image.crystalapps.kecommerce.databinding.setProfileContent
import image.crystalapps.kecommerce.databinding.snackBarSetup
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes
import image.crystalapps.kecommerce.ui.mainactivity.MainViewModel

class MainActivity : BaseActivity<MainViewModel, MainDataBinding>(){

    @Inject
    lateinit var   mSaveTokenSharedPreferenceHelper : SaveTokenSharedPreferenceHelper

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory
    private lateinit var mDrawer: DrawerLayout
    private var mActivityMainBinding: MainDataBinding? = null
    private lateinit var appBarConfiguration: AppBarConfiguration
     private  lateinit var mSharedPreferenceEntry:SharedPreferenceEntry

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          mActivityMainBinding = getViewDataBinding()
          window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setupNavigationDrawer()
        setUpNavigationComponent()

        mSharedPreferenceEntry = mSaveTokenSharedPreferenceHelper.getTokenInformation()

        setUpUi()

    }


  private fun setUpUi(){
      mActivityMainBinding?.root?.
          snackBarSetup(this,
              getViewModel().snackBarText , Snackbar.LENGTH_LONG)

       getViewModel().userProfile.observe(this, Observer {firebaseUser->
          mActivityMainBinding?.run { this.root.setProfileContent(firebaseUser) } })
  }

        private fun setData(){

        val uri1: Uri = Uri.parse("android.resource://image.crystalapps.kecommerce/drawable/jeans")
        val varietiesArray=ArrayList<Sizes>()
        val varietiesArray1=ArrayList<Sizes>()

        val varieties=  Sizes("" ,uri1.toString())
        val varieties1=  Sizes("S",null)
        val varieties2=  Sizes("M",null)
        val varieties3=  Sizes("L",null)
        val varieties4=  Sizes("XL",null)


            varietiesArray.add(varieties)
            varietiesArray1.add(varieties1)
            varietiesArray1.add(varieties2)
            varietiesArray1.add(varieties3)
            varietiesArray1.add(varieties4)

        val productDetails=ArrayList<ProductsDetails>()
        val productsDetailsItem1 =ProductsDetails("Varietes",varietiesArray )
        val productsDetailsItem2 =ProductsDetails("sizes",varietiesArray1 )

        productDetails.add(productsDetailsItem1)
        productDetails.add(productsDetailsItem2)

          val uri: Uri = Uri.parse("android.resource://image.crystalapps.kecommerce/drawable/jeans")
          val products=  Products("Black T Shirt","SM!2443",uri.toString(),"Black T -shirt with design","12200",productDetails)

            Firebase.firestore.collection("Fashion").document("products")
                .collection("Women").document().set(products)
    }

    //Navigation Functions
    private fun setUpNavigationComponent(){
        val navController: NavController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration =AppBarConfiguration(navController.graph,mDrawer)
        findViewById<NavigationView>(R.id.navigationView)
            .setupWithNavController(navController) }
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
    override fun getViewModel(): MainViewModel {
        return ViewModelProvider(this, viewModelProviderFactory).get(
            MainViewModel::class.java)

    }
    override fun getBindingVariable(): Int {
        return BR.viewModel}
    fun setGoogleAuth(firebaseAuth: FirebaseAuth?) {
        getViewModel().checkGoogleAuthentication(mSharedPreferenceEntry.token ,firebaseAuth) }
    override fun onStart() {
        super.onStart()
        getViewModel().checkGoogleAuthentication( mSharedPreferenceEntry.token,Firebase.auth)
    }

}