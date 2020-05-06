package at.swt.hotel;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    public static final String DB_NAME = "Hotel_db";
    private boolean firstRun = false;
    private ListView hotelList;

    private int pictures[] = {R.drawable.hotel_1,R.drawable.hotel_2,R.drawable.hotel_3,R.drawable.hotel4_1};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        hotelList = (ListView) findViewById(R.id.hotel_list);


        AppDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                DB_NAME)
                .allowMainThreadQueries()
                .build();

        SharedPreferences preferences = getSharedPreferences("HOTEL_PREFS", 0);
        firstRun = preferences.getBoolean("FIRST_RUN", true);
        if (firstRun)
        {
            DataInitializer dataInitializer = new DataInitializer();
            dataInitializer.initBasicData(db);
            preferences = getSharedPreferences("HOTEL_PREFS", 0);
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("FIRST_RUN", false);
            editor.apply();
        }


        Button btn_sort = findViewById(R.id.btn_sort);
        Button btn_login = findViewById(R.id.btn_Login_main);
        Button btn_filter = findViewById(R.id.btn_filter);
        switchToHotelView(btn_sort);
        switchToLoginView(btn_login);
        switchToFilterView(btn_filter);


        List<Hotel> hotels = db.hotelDao().getHotels();


        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),hotels, pictures);
        hotelList.setAdapter(customAdapter);

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