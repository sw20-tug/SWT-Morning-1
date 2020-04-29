package at.swt.hotel;


import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.content.Intent;
import android.view.View;
import android.widget.Button;


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

        Button btn_sort = findViewById(R.id.btn_sort);
        Button btn_login = findViewById(R.id.btn_Login_main);
        Button btn_filter = findViewById(R.id.btn_filter);
        switchToHotelView(btn_sort);
        switchToLoginView(btn_login);
        switchToFilterView(btn_filter);
    }
    
    public void switchToHotelView(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent HotelActivityIntent = new Intent(MainActivity.this, HotelViewActivity.class);
                MainActivity.this.startActivity(HotelActivityIntent);

            }
         });
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

    public void switchToLoginView(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginActivityIntent = new Intent(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(LoginActivityIntent);

            }
        });
    }

    public void switchToFilterView(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginActivityIntent = new Intent(MainActivity.this, FilterActivity.class);
                MainActivity.this.startActivity(LoginActivityIntent);

            }
        });
    }
}