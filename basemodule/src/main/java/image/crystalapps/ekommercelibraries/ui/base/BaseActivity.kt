//package image.crystalapps.ekommercelibraries.ui.base
//
//import android.app.Activity
//import android.content.Context
//import android.content.Intent
//import android.os.Bundle
//import android.os.Parcelable
//import android.view.View
//import android.view.inputmethod.InputMethodManager
//import android.widget.ProgressBar
//import androidx.annotation.LayoutRes
//import androidx.appcompat.app.AppCompatActivity
//import androidx.databinding.DataBindingUtil
//import androidx.databinding.ViewDataBinding
//import androidx.lifecycle.ViewModel
//import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.auth.FirebaseUser
//import com.google.firebase.auth.ktx.auth
//import com.google.firebase.ktx.Firebase
//import dagger.android.support.DaggerAppCompatActivity
//import kotlin.reflect.KClass
//
//
//abstract class BaseActivity<out VM : ViewModel ,out VDB : ViewDataBinding> : AppCompatActivity(){
//
//
//    private var progressBar :ProgressBar?=null
//    private  var mViewDataBinding :VDB?=null
//
//    private  var mViewModel :VM? =null
//    lateinit var mGoogleAuth :FirebaseAuth
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        performDataBinding()
//
//    }
//
//    fun  getGoogleAuth() : FirebaseAuth {
//        return mGoogleAuth }
//
//    fun getGoogleCurrentUser() : FirebaseUser?{
//        if (mGoogleAuth!=null){
//            return mGoogleAuth.currentUser }
//        return null }
//
//
//
//    abstract fun getBindingVariable(): Int
//
//    @LayoutRes
//    abstract fun getLayoutId(): Int
//
//  abstract  fun getViewModel() :VM
//
//
//   open  fun setProgressBar(progress :ProgressBar){
//        progressBar =progress
//    }
//
//   open  fun showProgressBar(){
//        if(progressBar!=null) {
//            progressBar?.visibility = View.VISIBLE
//        }
//
//    }
//
//
//    open fun hideProgressBar(){
//
//        if(progressBar!=null) {
//            progressBar?.visibility = View.INVISIBLE
//        }
//
//    }
//
//
//    override fun onStop() {
//        super.onStop()
//        hideProgressBar() }
//
//    open fun hideKeyboard() {
//        val view = this.currentFocus
//        if (view != null) {
//            val imm: InputMethodManager =
//                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//            imm.hideSoftInputFromWindow(view.windowToken, 0)
//        }
//    }
//
//    open fun getViewDataBinding(): VDB? {
//        return mViewDataBinding }
//
//
//     private fun performDataBinding() {
//        mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutId())
//        this.mViewModel = if (mViewModel == null) getViewModel() else mViewModel
//        mViewDataBinding?.run {
//            setVariable(getBindingVariable(), mViewModel)
//            executePendingBindings()
//        }
//        }
//
//
//
//   open  fun newActivity(baseActivity :BaseActivity<*,*> ,type :Class<Any>){
//        val intent=   Intent(baseActivity,type)
//       startActivity(intent) }
//
//
//
//}