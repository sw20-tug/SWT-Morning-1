package at.swt.hotel;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(tableName = "hotelrating")
public class HotelRating {

    public HotelRating(
            final int    hotelId,
            final int    userId,
            final int    rating,
            final String comment
    ) {
        this.hotelId = hotelId;
        this.userId  = userId;
        this.rating  = rating;
        this.comment = comment;
    }

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ForeignKey(entity = Hotel.class, parentColumns = "id", childColumns = "hotelId")
    public int hotelId;

    @ForeignKey(entity = User.class, parentColumns = "id", childColumns = "userId")
    public int userId;

    @ColumnInfo(name = "rating")
    public int rating;

    @ColumnInfo(name = "comment")
    public String comment;
}
