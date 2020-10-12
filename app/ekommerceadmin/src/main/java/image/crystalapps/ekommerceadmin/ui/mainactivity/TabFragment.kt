package image.crystalapps.ekommerceadmin.ui.mainactivity

import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import image.crystalapps.ekommerceadmin.NavigationUtils.FragmentUtils
import image.crystalapps.ekommerceadmin.R

import image.crystalapps.ekommercelibraries.ui.base.BaseFragment

class TabFragment :BaseFragment(){





    val section ="home"
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return when(section){


            FragmentUtils.HOME_INDEX->{

                createHomeView(inflater ,container)

            }


        }


    }

    fun createHomeView(inflater: LayoutInflater ,container: ViewGroup?){
    val ind=    DataBindingUtil.inflate(inflater , R.layout.fragment_home ,container,false)



    }

}