package image.crystalapps.ekommerceAdmin.ui.menfashionlist

import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import dagger.Module
import dagger.Provides
import image.crystalapps.ekommerceAdmin.adapter.MenFashionAdapter

@Module
class MenFashionListAdapterModule {


    @Provides
    fun  provideMenFashionAdapter(menFashionActivity :MenFashionList):MenFashionAdapter{
          val  firestore= Firebase.firestore

                val query = firestore.collection("restaurant")
                     .orderBy(
                "avgRating", Query.Direction.DESCENDING).limit(10.toLong())

        return MenFashionAdapter(query ,menFashionActivity)

    }

}