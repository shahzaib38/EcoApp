package image.crystalapps.ekommerceadmin.ui.mainactivity

import   android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomnavigation.BottomNavigationView
import image.crystalapps.ekommerceadmin.BR
import image.crystalapps.ekommerceadmin.R
import image.crystalapps.ekommercelibraries.ui.base.BaseActivity
import image.crystalapps.ekommercelibraries.viewmodel.ViewModelProviderFactory
import javax.inject.Inject

class MainActivity :  BaseActivity<MainViewModel ,ActivityMainBinding>()  ,BottomNavigationView.OnNavigationItemSelectedListener{

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val navigationBottomView = findViewById<BottomNavigationView>(R.id.bottom_navigation)
        navigationBottomView.setOnNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
          R.id.home ->{
              Toast.makeText(this, "Working" ,Toast.LENGTH_LONG).show()

          }



        }
        return true
    }


    fun changeFragment(fragment :Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.containerfragment,fragment)
    }

    override fun getBindingVariable(): Int {
      return  BR.viewModel }

    override fun getLayoutId(): Int {
  return      R.layout.activity_main
    }

    override fun getViewModel(): MainViewModel {
        return  ViewModelProvider(this, viewModelProviderFactory).get(
            MainViewModel::class.java);
    }


}
