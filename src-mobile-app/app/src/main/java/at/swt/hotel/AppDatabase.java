package at.swt.hotel;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class, Hotel.class, HotelInterest.class, HotelPicture.class, HotelRating.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserDao userDao();
    public abstract HotelDao hotelDao();
}