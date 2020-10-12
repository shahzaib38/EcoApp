package image.crystalapps.ekommerceAdmin.ui.menfashionlist

import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import image.crystalapps.ekommerceAdmin.BR
import image.crystalapps.ekommerceAdmin.R
import image.crystalapps.ekommerceAdmin.adapter.MenFashionAdapter
import image.crystalapps.ekommerceAdmin.adapter.OnMenFashionSelectedListener
import image.crystalapps.ekommerceAdmin.viewmodel.ViewModelProviderFactory
import image.crystalapps.ekommercelibraries.ui.base.BaseActivity
import javax.inject.Inject
import image.crystalapps.ekommerceAdmin.databinding.MenFashionListBinding
import image.crystalapps.ekommerceAdmin.ui.firebasedemo.OnRestaurantSelectedListener
import image.crystalapps.ekommerceAdmin.ui.firebasedemo.RestaurantAdapter

class MenFashionList :  BaseActivity<MenFashionListViewModel,MenFashionListBinding>() , OnMenFashionSelectedListener {

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

 //   @Inject


    lateinit var adapter: MenFashionAdapter

    lateinit var firestore : FirebaseFirestore


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN , WindowManager.LayoutParams.FLAG_FULLSCREEN)
        val menFashionListBinding = getViewDataBinding()
        menFashionListBinding?.viewModel=getViewModel()
        firestore= Firebase.firestore


                val query = firestore.collection("restaurant")
                     .orderBy(
                "avgRating", Query.Direction.DESCENDING).limit(10.toLong())

        adapter=    object : MenFashionAdapter(query  ,this@MenFashionList) {



//
//
//
//            override fun onDataChanged() {
//                println("Data Changed")
//                if (itemCount == 0) {
//                    menFashionListBinding?.menFashionRecyclerview?.visibility = View.GONE
//                    menFashionListBinding?.viewEmpty?.visibility = View.VISIBLE
//
//                } else {
//                    menFashionListBinding?.menFashionRecyclerview?.visibility = View.VISIBLE
//                    menFashionListBinding?.viewEmpty?.visibility = View.GONE
//                }
//            }
//
//            override fun onError(e: FirebaseFirestoreException?) {
//                Snackbar.make(menFashionListBinding!!.root  ,e.toString() , Snackbar.LENGTH_LONG).show()
//            }
        }

      menFashionListBinding?.apply {
            menFashionRecyclerview.layoutManager = LinearLayoutManager(this@MenFashionList)
        //    menFashionRecyclerview.adapter = adapter
      }?:println("Null Recyclerview")

    }



    override fun getBindingVariable(): Int {
        return  BR.viewModel }

    override fun getLayoutId(): Int {
        return R.layout.activity_men_list
    }

    override fun getViewModel(): MenFashionListViewModel {
        return  ViewModelProvider(this, viewModelProviderFactory).get(
            MenFashionListViewModel::class.java);
    }

    override fun onStart() {
        super.onStart()
  //    adapter.startListening()
    }

    override fun onStop() {
        super.onStop()
   //     adapter.stopListening()

    }

    override fun onSelectedRestaurant(menFashionItem: DocumentSnapshot) {
        Toast.makeText(this ,"testing" ,Toast.LENGTH_LONG).show()
    }
}
