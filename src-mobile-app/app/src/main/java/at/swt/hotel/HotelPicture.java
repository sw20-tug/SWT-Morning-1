package at.swt.hotel;

import android.graphics.Bitmap;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "hotelpicture")
public class HotelPicture {

    public HotelPicture(
            final int id,
            final int hotelId,
            final byte[] picture
    ) {
        this.id = id;
        this.hotelId = hotelId;
        this.picture = picture;
    }

    public HotelPicture() {}

    @PrimaryKey
    public int id;

    @ForeignKey(entity = Hotel.class, parentColumns = "id", childColumns = "hotelId")
    public int hotelId;

    @ColumnInfo(name = "picture")
    public byte[] picture;
}
