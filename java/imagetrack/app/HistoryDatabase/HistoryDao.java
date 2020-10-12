package imagetrack.app.HistoryDatabase;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface HistoryDao {


    @Query("SELECT * FROM HistoryBean")
    Flowable<List<HistoryBean>>  getAll();


    @Insert
    void insert(HistoryBean... historyBean);

    @Delete
    void delete(HistoryBean historyBean);




}
