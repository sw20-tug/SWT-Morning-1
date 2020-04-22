package at.swt.hotel;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class MainActivity extends AppCompatActivity {

    public static final String DB_NAME = "Hotel_db";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                DB_NAME)
                .allowMainThreadQueries()
                .build();

        //TODO: fill database like this
        db.userDao().insertAll(new User(1,"LustMolch", "test@test.com", null, null));

        for (User u : db.userDao().getAll()) {
            Log.d("HOTEL_DEBUG", u.name);
        }
    }

    private void addHotel(
            final AppDatabase   db,
            final Hotel         hotel,
            final HotelInterest hotelInterest,
            final HotelPicture  hotelPicture,
            final HotelRating   hotelRating) {

        db.hotelDao().insertHotels(hotel);
        db.hotelDao().insertHotelInterests(hotelInterest);
        db.hotelDao().insertHotelPictures(hotelPicture);
        db.hotelDao().insertHotelRatings(hotelRating);
    }
}