package image.crystala


import android.net.Uri
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.activity.viewModels
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.Source
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.google.firebase.messaging.FirebaseMessaging
import com.google.type.Date
import dagger.hilt.android.AndroidEntryPoint
import image.crystalapps.kecommerce.BR
import image.crystalapps.kecommerce.data.database.prefs.SaveTokenSharedPreferenceHelper
import image.crystalapps.kecommerce.data.database.prefs.SharedPreferenceEntry
import image.crystalapps.kecommerce.databinding.MainDataBinding
import image.crystalapps.kecommerce.databinding.snackBarSetup
import image.crystalapps.kecommerce.ui.base.BaseActivity
import image.crystalapps.kecommerce.ui.mainactivity.MainViewModel
import javax.inject.Inject
import image.crystalapps.kecommerce.R
import image.crystalapps.kecommerce.extensions.setupWithNavController
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

    private var currentNavController: LiveData<NavController>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
          mActivityMainBinding = getViewDataBinding()
          window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
              WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setSupportActionBar(findViewById(image.crystalapps.kecommerce.R.id.toolbar))
       // setupNavigationDrawer()
        //setUpNavigationComponent()
        mSharedPreferenceEntry = mSaveTokenSharedPreferenceHelper.getTokenInformation()
        setUpUi()


//        mViewModel.all.observe(this, Observer{
//
//            it.forEach {
//
//                println("check data ${it.productName}")
//            }
//        })
//        mViewModel.getCurrentRepositoryData().observe(this , Observer {
//            Toast.makeText(this ,it.toString() ,Toast.LENGTH_LONG).show()
//
//        })

//call()
//
//        val mQuery = Firebase.firestore.collection("Fashion List").document("Men")
//            .collection("Products")
//
//        mQuery.get(Source.SERVER).addOnSuccessListener {
//
//            println("Values of Object ${it.toObjects(Products::class.java)}")
//        }.addOnFailureListener {
//
//            println("Exception ${it.message}")
//        }

        setupBottomNavigationBar()
    }


    override fun onPause() {
        super.onPause()


    }



//
//    fun setFireFcm(){
////
////     val date=   java.sql.Date(2020,12,2)
////        mViewModel.insert(NotificationBean(0,"Baloch Test ", "Test Notification value is goog","",Converters.dateToTimeStamp(date)))
//
//
//        FirebaseMessaging.getInstance().token.addOnCompleteListener(OnCompleteListener { task ->
//            if (!task.isSuccessful) {
//                System.out.println( "Fetching FCM registration token failed ${task.exception}")
//                return@OnCompleteListener
//            }
//
//            // Get new FCM registration token
//            val token = task.result
//
//            // Log and toast
//            if(token!=null) {
//                System.out.println(token)
//                Toast.makeText(baseContext, token, Toast.LENGTH_SHORT).show()
//            }
//        })
//
//    }


  private fun setUpUi(){
      mActivityMainBinding?.root?.
          snackBarSetup(this,
              getViewModel().snackBarText , Snackbar.LENGTH_LONG)

//      mViewModel.getUserProfile().observe(this, Observer {firebaseUser->
//          mActivityMainBinding?.run { this.root.setProfileContent(firebaseUser) } })


    //  setData()
  }

    //Navigation Functions
//    private fun setUpNavigationComponent(){
//        val navController: NavController = findNavController(R.id.nav_host_fragment)
//        appBarConfiguration =AppBarConfiguration(navController.graph,mDrawer)
//
//        setupActionBarWithNavController(navController, appBarConfiguration)
//
//        findViewById<NavigationView>(R.id.navigationView)
//            .setupWithNavController(navController)
//    }

//    override fun onSupportNavigateUp(): Boolean {
//        return findNavController(R.id.nav_host_fragment).navigateUp(appBarConfiguration) ||
//                super.onSupportNavigateUp() }
//    private  fun setupNavigationDrawer(){
//        mDrawer =(findViewById<DrawerLayout>(R.id.drawer_layout))
//            .apply {
//                setStatusBarBackground(R.color.colorPrimaryDark)
//            }
//
//    }

//    // DrawerLayout Functions
//    private fun  UnlockDrawer(){
//        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED) }
    override fun onResume() {
        super.onResume()
//        mDrawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED)
        checkAuthentication()

//

    }


    private fun setupBottomNavigationBar() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_nav)

        val navGraphIds = listOf(R.navigation.home_nav, R.navigation.cart_nav,R.navigation.wish_list_nav ,R.navigation.account_nav)

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = bottomNavigationView.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

        // Whenever the selected controller changes, setup the action bar.
//        controller.observe(this, Observer { navController ->
//            setupActionBarWithNavController(navController)
//        })
        currentNavController = controller
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController?.value?.navigateUp() ?: false
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



companion object  {
     fun getProducts(): Products {
        val uri1: Uri = Uri.parse("android.resource://image.crystalapps.kecommerce/drawable/jeans")
        val varietiesArray = ArrayList<Sizes>()
        val varietiesArray1 = ArrayList<Sizes>()

        val varieties = Sizes("", uri1.toString())
        val varieties1 = Sizes("S", null)
        val varieties2 = Sizes("M", null)
        val varieties3 = Sizes("L", null)
        val varieties4 = Sizes("XL", null)

        varietiesArray.add(varieties)
        varietiesArray1.add(varieties1)
        varietiesArray1.add(varieties2)
        varietiesArray1.add(varieties3)
        varietiesArray1.add(varieties4)

        val productDetails = ArrayList<ProductsDetails>()
        val productsDetailsItem1 = ProductsDetails("Varietes", varietiesArray)
        val productsDetailsItem2 = ProductsDetails("sizes", varietiesArray1)

        productDetails.add(productsDetailsItem1)
        productDetails.add(productsDetailsItem2)
        val uri: Uri = Uri.parse("android.resource://image.crystalapps.kecommerce/drawable/jeans")

        val uriArray = ArrayList<String>()
        uriArray.add(uri.toString())
        uriArray.add(uri.toString())
        uriArray.add(uri.toString())


        val products = Products(
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
            productDetails
        )
        return products
    }
}


    fun call(){

        val mQuery = Firebase.firestore.collection("Fashion List").document("Men")
            .collection("Products").limit(10)


        val list =getQueryData(mQuery)
        println("3")

        val objectss= toObject(list)
        println("4")

        //   val lastVisible=       getNextPageKey(list)

        println("5")

        if(objectss.isNotEmpty()){
            println("Not Empty")

        }else{
            println("Empty")


        }


    }

    fun getQueryData(query : Query) :List<DocumentSnapshot>{
        val list =ArrayList<DocumentSnapshot>()
        println("getQuery data ${Thread.currentThread()}")

        println("query 1")
        query.get().addOnSuccessListener {
            println("query 2")
            println("SuccessFull ${Thread.currentThread()}")

            it.forEach {
                list.add(it)

                println("query 3")

            }
            print("query 4")
        }
        return list }

    fun toObject(list: List<DocumentSnapshot>) :List<Products> {
        val products =ArrayList<Products>()
        println("to Object ${Thread.currentThread()}")


        products.add(getProducts())
        products.add(getProducts())
        products.add(getProducts())
        products.add(getProducts())
        products.add(getProducts())
        products.add(getProducts())
        products.add(getProducts())
        products.add(getProducts())
        products.add(getProducts())
        products.add(getProducts())

//
//        list.forEach {
//
//            products.add(MainActivity.getProducts())
//            products.add(it.toObject(Products::class.java)!!) }
        return products }
}