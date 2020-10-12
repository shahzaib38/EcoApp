package imagetrack.app.HistoryDatabase;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import imagetrack.app.trackobject.Constants.Constants;

import static androidx.work.impl.WorkDatabaseMigrations.MIGRATION_1_2;

@Database(entities = {HistoryBean.class}, version = 1)
public abstract class HistoryDatabase  extends RoomDatabase {

    public static HistoryDatabase INSTANCE;
    public abstract HistoryDao userDao();





   public static HistoryDatabase getInstance(Context context){

    if (INSTANCE==null) {

        synchronized (HistoryDatabase.class) {

            if (INSTANCE==null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        HistoryDatabase.class, Constants.MYHISTORYDATABASE).addMigrations(MIGRATION_1_2, MIGRATION_2_3).build();
            }
        }

    }

    return INSTANCE;
    }


    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE Book "
                    + " ADD COLUMN pub_year INTEGER");
        }
    };

}
