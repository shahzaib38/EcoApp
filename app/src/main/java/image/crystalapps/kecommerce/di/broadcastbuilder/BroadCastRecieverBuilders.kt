package image.crystalapps.kecommerce.di.broadcastbuilder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import image.crystalapps.kecommerce.broadcast.BaseBroadCastReciever


@Module
abstract class BroadCastRecieverBuilders {


    @ContributesAndroidInjector
    abstract fun baseBroaddCastReciever() : BaseBroadCastReciever


}