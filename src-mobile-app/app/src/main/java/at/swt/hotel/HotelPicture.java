package at.swt.hotel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "hotelpicture")
public class HotelPicture {

    public HotelPicture(
            final int    hotelId,
            final byte[] picture
    ) {
        this.hotelId = hotelId;
        this.picture = picture;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ForeignKey(entity = Hotel.class, parentColumns = "id", childColumns = "hotelId")
    public int hotelId;

    @ColumnInfo(name = "picture")
    public byte[] picture;
}
