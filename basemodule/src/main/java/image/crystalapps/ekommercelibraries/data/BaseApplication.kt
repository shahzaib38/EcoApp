package image.crystalapps.ekommercelibraries.data

import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

abstract class  BaseApplication  :DaggerApplication(){



 abstract fun setComponent(baseComponent :BaseComponent)

 override fun applicationInjector(): AndroidInjector<out DaggerApplication> {

  val build = DaggerBaseComponent.create()
   setComponent(build)
  build.inject(this)
  return build
 }


}