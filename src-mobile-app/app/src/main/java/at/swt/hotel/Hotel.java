package at.swt.hotel;

import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "hotel")
public class Hotel {

    public Hotel(
            final int                 id,
            final String              name,
            final String              location,
            final String              price,
            final String              category,
            final String              description,
            final byte[]              thumbnail,
            final int                 stars
    ) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.price = price;
        this.category = category;
        this.description = description;
        this.thumbnail = thumbnail;
        this.stars = stars;
    }

    @PrimaryKey
    @ColumnInfo(name = "id")
    public int id;

    @ColumnInfo(name = "name")
    public String name;

    @ColumnInfo(name = "location")
    public String location;

    @ColumnInfo(name = "price")
    public String price;

    @ColumnInfo(name = "category")
    public String category;

    @ColumnInfo(name = "description")
    public String description;

    @ColumnInfo(name = "thumbnail")
    public byte[] thumbnail;

    @ColumnInfo(name = "stars")
    public int stars;

}

