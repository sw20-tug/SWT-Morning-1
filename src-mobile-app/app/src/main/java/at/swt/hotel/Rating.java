package at.swt.hotel;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

public class Rating {

    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "rating")
    public int rating;

    @ColumnInfo(name = "comment")
    public String comment;

    @ColumnInfo(name = "user")
    public User user;
}
