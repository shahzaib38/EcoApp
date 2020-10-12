package image.crystalapps.ekommerceAdmin.adapter

import android.util.Log
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.google.firebase.firestore.*
import image.crystalapps.ekommercelibraries.adapter.BaseAdapter

abstract class FireStoreAdapter<T,VB : ViewDataBinding,VH :RecyclerView.ViewHolder>(private var query :Query) :


    BaseAdapter<DocumentSnapshot,VB ,VH>()  ,EventListener<QuerySnapshot> {


    private var register :ListenerRegistration?=null

     private val snapShot =ArrayList<DocumentSnapshot>()

    //override val snapshot: List<T>?
      //  get() = ArrayList<T>()




    override fun onEvent(documentSnapshots : QuerySnapshot?, e: FirebaseFirestoreException?) {

        println("Event Called")

        if (e==null){
            Log.w("test" , "OnEvent:Error$e")
            onError(e)
        }

        if (documentSnapshots==null) { return }
        Log.d("test", "onEvent:numChanges:" + documentSnapshots.documentChanges.size)

        onDataChanged()

        for (change in documentSnapshots.documentChanges) {
            when (change.type) {
                DocumentChange.Type.ADDED -> onDocumentAdded(change)
                DocumentChange.Type.MODIFIED -> onDocumentModified(change)
                DocumentChange.Type.REMOVED -> onDocumentRemoved(change)
            }
        }


    }

   private fun onDocumentRemoved(change: DocumentChange){
        println("Data Removed")
        snapShot.removeAt(change.oldIndex)
        notifyItemRemoved(change.oldIndex)
    }


   private fun onDocumentModified(change :DocumentChange){
        println("Data Modified")
        if (change.oldIndex == change.newIndex) {
            // Item changed but remained in same position
            snapShot[change.oldIndex] = change.document
            notifyItemChanged(change.oldIndex)
        } else {
            // Item changed and changed position
            snapShot.removeAt(change.oldIndex)
            snapShot.add(change.newIndex, change.document)
            notifyItemMoved(change.oldIndex, change.newIndex)
        }
    }


    private fun onDocumentAdded(change: DocumentChange) {
        println("Data Added")
        snapShot.add(change.newIndex, change.document)
        notifyItemInserted(change.newIndex)
    }


    fun startListening(){
         if(query!=null && register==null){
             register=  query.addSnapshotListener(this) } }


    fun stopListening(){
        register?.remove()
        register=null
        snapShot.clear()
        notifyDataSetChanged() }


  open  fun onDataChanged(){


    }

    fun setQuery(query: Query) {
        // Stop listening
        stopListening()

        // Clear existing data
        //
        snapShot.clear()
        notifyDataSetChanged()

        // Listen to new query
        this.query = query
        startListening()
    }
  open  fun onError(e :FirebaseFirestoreException?){

      if (e!=null) {
          Log.w("test", "OnError $e")
      }
      }

protected    fun getSnapshot(index :Int) :DocumentSnapshot{
        return snapShot[index] }




     override fun getItemCount(): Int {
         return snapShot.size
     }




 }