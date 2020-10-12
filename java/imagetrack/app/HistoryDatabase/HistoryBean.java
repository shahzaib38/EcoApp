package imagetrack.app.HistoryDatabase;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class HistoryBean {

    @PrimaryKey(autoGenerate = true)
    public int id;


    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @ColumnInfo(name="historyvalue")
    public String value;


}
