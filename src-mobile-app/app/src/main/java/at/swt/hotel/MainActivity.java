package at.swt.hotel;


import android.content.SharedPreferences;
import android.graphics.Picture;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final String DB_NAME = "Hotel_db";
    private boolean firstRun = false;
    private ListView hotelList;


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
        Button btn_delete = findViewById(R.id.btn_delete_hotel);
        Button btn_edit = findViewById(R.id.btn_editHotel);
        Button btn_logout = findViewById(R.id.btn_logout);
        Button btn_add_hotel = findViewById(R.id.btn_add_hotel);
        //ImageButton btn_search = findViewById(R.id.btn_delete_hotel)
        btn_delete.setVisibility(View.INVISIBLE);
        btn_edit.setVisibility(View.INVISIBLE);
        btn_logout.setVisibility(View.INVISIBLE);
        btn_add_hotel.setVisibility(View.INVISIBLE);

        if (getIntent().getExtras() != null)
        {
            Bundle bun=getIntent().getExtras();
            int val=bun.getInt("VAL");
            if(val == 1) {
                btn_delete.setVisibility(View.VISIBLE);
                btn_edit.setVisibility(View.VISIBLE);
                btn_logout.setVisibility(View.VISIBLE);
                btn_add_hotel.setVisibility(View.VISIBLE);
                btn_sort.setVisibility(View.INVISIBLE);
                btn_login.setVisibility(View.INVISIBLE);
                btn_filter.setVisibility(View.INVISIBLE);
            } else if (val == 2) {
                btn_delete.setVisibility(View.INVISIBLE);
                btn_edit.setVisibility(View.INVISIBLE);
                btn_logout.setVisibility(View.INVISIBLE);
            }
        }
        switchToHotelView(btn_sort);
        switchToLoginView(btn_login);
        switchToFilterView(btn_filter);
        logOutAdmin(btn_logout);



        List<Hotel> hotels = db.hotelDao().getHotels();
        List<HotelPicture> hotelpictures = db.hotelDao().getHotelPictures();

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), hotels, hotelpictures);
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

    public void logOutAdmin(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent LogoutIntent = new Intent(MainActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putInt("VAL", 2);
                getIntent().putExtras(bundle);
                finish();
                overridePendingTransition(0,0);
                startActivity(getIntent());
                overridePendingTransition(0,0);
               // MainActivity.this.startActivity(LogoutIntent);

            }
        });
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