//package image.crystalapps.ekommercelibraries.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import androidx.databinding.DataBindingUtil
//import androidx.databinding.ViewDataBinding
//import androidx.recyclerview.widget.RecyclerView
//import androidx.viewbinding.ViewBinding
//import image.crystalapps.ekommercelibraries.R
//
//abstract class BaseAdapter<T ,VB : ViewDataBinding,VH  : RecyclerView.ViewHolder> :RecyclerView.Adapter<BaseViewHolder<VB>>() {
//
//
//
//    abstract val snapshot :List<T>
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VB> {
//        val layoutInflator = LayoutInflater.from(
//            parent.context)
//        val createBinding = createBinding(layoutInflator, parent)
//        return BaseViewHolder(createBinding)
//
//    }
//
//
//    abstract fun createBinding(layoutInflator :LayoutInflater ,viewGroup: ViewGroup):VB
//
//
//    override fun onBindViewHolder(holder: BaseViewHolder<VB>, position: Int){
//        bind(holder.binding ,snapshot.get(position))
//
//    }
//
//    abstract fun bind(binding :VB ,item :T?)
//
//
//}