package image.crystalapps.kecommerce.data.database.local.notification

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import image.crystalapps.kecommerce.model.NotificationBean



@Database(entities = [NotificationBean::class],version = 1 ,exportSchema = false)
abstract  class NotificationDataBase :RoomDatabase() {

    abstract  fun taskDao() : NotificationDao

    companion object {

        @Volatile
        private var INSTANCE: NotificationDataBase? = null

        @VisibleForTesting
        private val DATABASE_NAME = "subscriptions-db"

        fun getInstance(context: Context): NotificationDataBase =
            INSTANCE
                ?: synchronized(this) {
                INSTANCE
                    ?: buildDatabase(
                        context.applicationContext
                    ).also {
                    INSTANCE    = it
                }
            }

        /**
         * Set up the database configuration.
         * The SQLite database is only created when it's accessed for the first time.
         */
        private fun buildDatabase(appContext: Context): NotificationDataBase {
            return Room.databaseBuilder(appContext, NotificationDataBase::class.java,
                DATABASE_NAME
            )
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}