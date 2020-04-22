package at.swt.hotel;

import java.util.List;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Hotel {

    @PrimaryKey(autoGenerate = true)
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

    @ColumnInfo(name= "pictures")
    public List<String> pictures;

    @ColumnInfo(name = "ratings")
    public List<Rating> ratings;

    @ColumnInfo(name = "activities")
    public List<HotelActivity> activities;
}

