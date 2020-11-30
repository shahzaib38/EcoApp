package image.crystalapps.kecommerce.data.database.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import image.crystalapps.kecommerce.model.NotificationBean

@Dao
interface NotificationDao {


    @Query("Select * from notifications")
    fun getAllNotificatios() : LiveData<List<NotificationBean>>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun insert(notification : NotificationBean)


}