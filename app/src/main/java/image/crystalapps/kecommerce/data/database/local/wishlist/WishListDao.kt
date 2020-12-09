package image.crystalapps.kecommerce.data.database.local.wishlist

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import image.crystalapps.kecommerce.model.NotificationBean
import image.crystalapps.kecommerce.model.WishModel

//@Dao
//interface WishListDao {
//
//
//
//    @Query("Select * from wishes")
//    fun getAllWishList() : LiveData<List<WishModel>>
//
//
//    @Insert(onConflict = OnConflictStrategy.REPLACE)
//    fun insert(notification : WishModel)
//
//
//}