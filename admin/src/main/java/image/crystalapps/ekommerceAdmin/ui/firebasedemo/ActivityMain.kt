package image.crystalapps.ekommerceAdmin.ui.firebasedemo

import  androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.auth.AuthUI
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import image.crystalapps.ekommerceAdmin.BR
import image.crystalapps.ekommerceAdmin.R
import image.crystalapps.ekommercelibraries.ui.base.BaseActivity
import image.crystalapps.ekommerceAdmin.databinding.ActivityMainBinding2
import image.crystalapps.ekommercelibraries.viewmodel.ViewModelProviderFactory
import kotlinx.android.synthetic.main.activity_main2.*
import javax.inject.Inject


class ActivityMain : BaseActivity<FireBaseMainViewModel, ActivityMainBinding2>()  ,FirebaseMainNavigator , OnRestaurantSelectedListener{


    lateinit var firestore :FirebaseFirestore


    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    lateinit var adapter:RestaurantAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var viewDataBinding = getViewDataBinding()

        viewDataBinding?.apply {
            setSupportActionBar(viewDataBinding.toolbar)
        }
       firestore= Firebase.firestore

        val query = firestore.collection("restaurant")
            .orderBy(
                "avgRating", Query.Direction.DESCENDING).limit(10.toLong())

   // adapter=    object : RestaurantAdapter(query  ,this@ActivityMain) {

//        override fun onDataChanged() {
//            println("Data Changed")
//            if (itemCount == 0) {
//                viewDataBinding?.recyclerRestaurants?.visibility = View.GONE
//                viewDataBinding?.viewEmpty?.visibility = View.VISIBLE
//            } else {
//                viewDataBinding?.recyclerRestaurants?.visibility = View.VISIBLE
//                viewDataBinding?.viewEmpty?.visibility = View.GONE
//            }
//        }
////
//        override fun onError(e: FirebaseFirestoreException) {
//            Snackbar.make(viewDataBinding!!.root  ,e.toString() ,Snackbar.LENGTH_LONG).show()
////        }

////
//        viewDataBinding?.apply {
//            recyclerRestaurants.layoutManager = LinearLayoutManager(this@ActivityMain)
//            recyclerRestaurants.adapter = adapter
//        }?:println("Null Recyclerview")
//

    }

    override fun getBindingVariable(): Int {
        return BR.viewModel }

    override fun getLayoutId(): Int {
      return R.layout.activity_main2
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.menu_add_items ->addItemClicked()
            R.id.menu_sign_out ->{
            //    AuthUI.getInstance().signOut(this)

            }



        }



        return super.onOptionsItemSelected(item)
    }


    fun addItemClicked(){

        val batch = firestore.batch()

        for (i in 0..9) {

            val restRef = firestore.collection("restaurant").document()

            //create restaurant / rating
            val randomRestaurant = RestaurantUtils.getRandom(this)
            batch.set(restRef, randomRestaurant)
        }
            batch.commit().addOnCompleteListener { task ->
                if (task.isSuccessful) {
                 //   Log.d(TAG, "Write batch succeeded.")
                } else {
                 //   Log.w(TAG, "write batch failed.", task.exception)
                }
            }





    }


    override fun getViewModel(): FireBaseMainViewModel {
       return ViewModelProvider(this,viewModelProviderFactory).get(FireBaseMainViewModel::class.java)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main ,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onSelectedRestaurant(restaurant: DocumentSnapshot) {
    }

    override fun onStart() {
        super.onStart()

      //  adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
    //    adapter.stopListening()
    }
}
