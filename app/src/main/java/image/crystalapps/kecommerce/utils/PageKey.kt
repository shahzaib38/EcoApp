package image.crystalapps.kecommerce.utils

import com.google.firebase.firestore.DocumentSnapshot
import com.google.firebase.firestore.Query

class PageKey(private  val startAfter :DocumentSnapshot? ,private val endBefore :DocumentSnapshot) {




    fun getPagedQuery(baseQuery : Query ,size :Long) : Query{
        var pageQuery:Query =baseQuery
        if(startAfter!=null){
            pageQuery =pageQuery.startAfter(startAfter) }

        if(endBefore!=null){
            pageQuery =pageQuery.endBefore(endBefore)
        }else{
            pageQuery= pageQuery.limit(size) }

        return pageQuery }


}