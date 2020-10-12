package image.crystalapps.ekommerceAdmin.data

import com.google.firebase.FirebaseApp
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import image.crystalapps.ekommercelibraries.data.BaseComponent
import image.crystalapps.ekommercelibraries.data.DaggerBaseComponent


class  AdminApplication  : DaggerApplication(){

        lateinit var baseComponent: BaseComponent

        override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        baseComponent()
            FirebaseApp.initializeApp(this)
        return DaggerEkommerceAdminComponent.factory().create(this ,baseComponent)}

         fun baseComponent(){
             baseComponent =DaggerBaseComponent.create()
        }
}