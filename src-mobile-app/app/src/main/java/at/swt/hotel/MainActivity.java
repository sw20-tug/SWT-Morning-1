package at.swt.hotel;


import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Picture;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.Array;
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
    public List<HotelContainer> hotelC;
    public static Context applicationContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        applicationContext = getApplicationContext();


        hotelList = (ListView) findViewById(R.id.hotel_list);

        SharedPreferences preferences = getSharedPreferences("HOTEL_PREFS", 0);
        firstRun = preferences.getBoolean("FIRST_RUN", true);
        if (firstRun)
        {
            HotelProvider.getInstance().initDataBase();
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

        refresh(HotelProvider.getInstance().getHotelContainerList());
    }

    public void refresh(List<HotelContainer> hotelContainers) {
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), hotelContainers);
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