package image.crystalapps.kecommerce.data

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import image.crystalapps.ekommercelibraries.data.BaseApplication
import image.crystalapps.ekommercelibraries.data.BaseComponent
import image.crystalapps.ekommercelibraries.data.DaggerBaseComponent
import javax.inject.Inject

class  ClientApplication  :DaggerApplication(){

    lateinit var baseComponent: BaseComponent

    @Inject
    lateinit var dataManager: DataManager

    fun BaseComponent(){
        baseComponent= DaggerBaseComponent.builder().build()
    }



    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
    BaseComponent()
         return DaggerAppComponent.factory().create(this,baseComponent)
 }

    override fun onCreate() {
        super.onCreate()
    }

}