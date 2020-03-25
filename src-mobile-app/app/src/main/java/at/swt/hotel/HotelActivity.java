package at.swt.hotel;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class HotelActivity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "type")
    public String type;

    @ColumnInfo(name = "description")
    public String description;

}
