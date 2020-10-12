package image.crystalapps.ekommerceAdmin.ui.menfashionlist

import  android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import image.crystalapps.ekommerceAdmin.adapter.MenFashionAdapter
import image.crystalapps.ekommerceAdmin.adapter.OnMenFashionSelectedListener

import image.crystalapps.ekommerceAdmin.data.DataManager
import image.crystalapps.ekommerceAdmin.ui.menfashion.MenFashion
import image.crystalapps.ekommercelibraries.ui.base.BaseViewModel
import kotlinx.coroutines.newFixedThreadPoolContext
import javax.inject.Inject

class MenFashionListViewModel  @Inject constructor(dataManager: DataManager):
    BaseViewModel<MenFashionListNavigator>(dataManager)  {





    fun navigate(view: View?){
        super.navigate(view?.context ,MenFashion::class.java) }




    }