package image.crystala


import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.type.Date
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.data.database.prefs.SaveTokenSharedPreferenceHelper
import image.crystalapps.kecommerce.data.database.prefs.SharedPreferenceEntry
import image.crystalapps.kecommerce.databinding.MainDataBinding
import image.crystalapps.kecommerce.databinding.setProfileContent
import image.crystalapps.kecommerce.databinding.snackBarSetup
import image.crystalapps.kecommerce.ui.base.BaseActivity
import image.crystalapps.kecommerce.ui.mainactivity.MainViewModel
import javax.inject.Inject
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.model.NotificationBean
import image.crystalapps.kecommerce.model.Products
import image.crystalapps.kecommerce.model.ProductsDetails
import image.crystalapps.kecommerce.model.Sizes
import image.crystalapps.kecommerce.utils.Converters

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

        setSupportActionBar(findViewById(image.crystalapps.kecommerce.R.id.toolbar))
        setupNavigationDrawer()
        setUpNavigationComponent()
        mSharedPreferenceEntry = mSaveTokenSharedPreferenceHelper.getTokenInformation()
        setUpUi()



    }


    override fun onPause() {
        super.onPause()


        Firebase.firestore.collection("Fashion List").document("Men")
            .collection("Products").document().set(getProducts())

    }




    fun setFireFcm(){
//
//     val date=   java.sql.Date(2020,12,2)
//        mViewModel.insert(NotificationBean(0,"Baloch Test ", "Test Notification value is goog","",Converters.dateToTimeStamp(date)))


        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
            if (!task.isSuccessful) {
                System.out.println( "Fetching FCM registration token failed ${task.exception}")
                return@OnCompleteListener
            }

            // Get new FCM registration token
            val token = task.result

            // Log and toast
            if(token!=null) {
                System.out.println(token)
                Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
            }
        })

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
    private fun  UnlockDrawer(){
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED) }
    override fun onResume() {
        super.onResume()
        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        checkAuthentication()


        Firebase.firestore.collection("Fashion List").document("Men")
            .collection("Products").document().set(getProducts())

    }
    fun checkAuthentication(){
      val mGoogleAuthentication=  Firebase.auth
        getViewModel().checkGoogleAuthentication(mSharedPreferenceEntry.token,mGoogleAuthentication) }

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




    private fun getProducts() : Products {
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
        val productsDetailsItem1 = ProductsDetails("Varietes",varietiesArray )
        val productsDetailsItem2 = ProductsDetails("sizes",varietiesArray1 )

        productDetails.add(productsDetailsItem1)
        productDetails.add(productsDetailsItem2)
        val uri: Uri = Uri.parse("android.resource://image.crystalapps.kecommerce/drawable/jeans")

        val uriArray =ArrayList<String>()
        uriArray.add(uri.toString())
        uriArray.add(uri.toString())
        uriArray.add(uri.toString())


        val products= Products(
            "Jeans",
            "men",
            "Black T Shirt",
            "12",
            4,
            "1.33",
            "SM22446",
            uriArray,
            "Black T -shirt with design",
            12200,
            productDetails)
        return products }

}