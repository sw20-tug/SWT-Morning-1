package at.swt.hotel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "hotelinterest")
public class HotelInterest {

    public HotelInterest(
            final int    hotelId,
            final String type,
            final String description
    ) {
        this.hotelId = hotelId;
        this.type = type;
        this.description = description;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ForeignKey(entity = Hotel.class, parentColumns = "id", childColumns = "hotelId")
    public int hotelId;

    @ColumnInfo(name = "type")
    public String type;

    @ColumnInfo(name = "description")
    public String description;
}
