package image.crystalapps.kecommerce.data

import android.app.Application
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import image.crystalapps.kecommerce.data.database.local.notification.NotificationDao
import image.crystalapps.kecommerce.data.database.local.notification.NotificationDataBase
//import image.crystalapps.kecommerce.data.database.local.wishlist.WishListDao
//import image.crystalapps.kecommerce.data.database.local.wishlist.WishesDataBase

@Module
@InstallIn(ApplicationComponent::class)
class DataBaseModule {



    @Provides
    fun getNotificationDao(application :Application) : NotificationDao {
        return NotificationDataBase.getInstance(application).taskDao()
    }


//
//    @Provides
//    fun getWishDao(application :Application) : WishListDao {
//        return WishesDataBase.getInstance(application).taskDao()
//    }

}