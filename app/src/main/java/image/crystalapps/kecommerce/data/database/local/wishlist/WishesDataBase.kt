package image.crystalapps.kecommerce.data.database.local.wishlist

import android.content.Context
import androidx.annotation.VisibleForTesting
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import image.crystalapps.kecommerce.model.WishModel
//
//@Database(version = 1 ,exportSchema = false)
//abstract class WishesDataBase :RoomDatabase(){
//
//    abstract  fun wishDao() : WishListDao
//
//    companion object {
//
//        @Volatile
//        private var INSTANCE: WishesDataBase? = null
//
//        @VisibleForTesting
//        private val DATABASE_NAME = "wishes-db"
//
//        fun getInstance(context: Context): WishesDataBase =
//            INSTANCE
//                ?: synchronized(this) {
//                    INSTANCE
//                        ?: buildDatabase(
//                            context.applicationContext
//                        ).also {
//                            INSTANCE = it
//                        }
//                }
//
//        /**
//         * Set up the database configuration.
//         * The SQLite database is only created when it's accessed for the first time.
//         */
//        private fun buildDatabase(appContext: Context): WishesDataBase {
//            return Room.databaseBuilder(appContext, WishesDataBase::class.java,
//                DATABASE_NAME
//            )
//                .fallbackToDestructiveMigration()
//                .build()
//        }
//    }
//
//
//}