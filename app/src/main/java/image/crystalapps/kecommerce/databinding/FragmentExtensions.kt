package image.crystalapps.kecommerce.databinding

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction


inline  fun FragmentManager.replaceOnce(containerViewid :Int ,fragmentTag :String ,body :()->Fragment, withBackStack :Boolean =true) :FragmentTransaction{

val transaction =    this.beginTransaction()
    val fragment= this.findFragmentByTag(fragmentTag)
    if(fragment ==null ){
        transaction.replace(containerViewid ,body() ,fragmentTag)
        if(withBackStack){
            transaction.addToBackStack(fragmentTag) } }

     return transaction }