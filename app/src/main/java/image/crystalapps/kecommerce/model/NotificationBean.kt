package image.crystalapps.kecommerce.model

import android.os.Parcel
import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*


@Entity(tableName = "notifications")
data class NotificationBean(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "entryid")
    var id: Int? =0,
    @ColumnInfo(name = "title")
    var title: String = "",
    @ColumnInfo(name="description")
    var description: String = ""
) : Model(){

}