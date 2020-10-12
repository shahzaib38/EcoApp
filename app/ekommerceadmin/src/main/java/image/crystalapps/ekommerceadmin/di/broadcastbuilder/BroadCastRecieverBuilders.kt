package image.crystalapps.ekommerceadmin.di.broadcastbuilder

import dagger.Module
import dagger.android.ContributesAndroidInjector
import image.crystalapps.ekommercelibraries.broadcast.BaseBroadCastReciever


@Module
abstract class BroadCastRecieverBuilders {


    @ContributesAndroidInjector
    abstract fun baseBroaddCastReciever() : BaseBroadCastReciever


}