package image.crystalapps.kecommerce.utils

import androidx.room.TypeConverter
import java.sql.Date
import java.util.*

object Converters {

    @TypeConverter
    fun fromTimeStamp(value :Long?):Date?{

        return if(value!=null){
            Date(value)

        }else{
            null
        }

    }

    @TypeConverter
    fun dateToTimeStamp(date:Date?):Long?{
        return date?.time


    }



}