package at.swt.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Filter;
import android.widget.ImageButton;

import java.io.Console;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        ImageButton btnSearch = findViewById(R.id.btnFilterSearch);
        switchToHotelView(btnSearch);
        Button priceButton0_50 = findViewById(R.id.priceToggle1);
        priceButton0_50.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setPriceFilter(0,50);
            }
        });

        Button setFilterButton = findViewById(R.id.applyFilterButton);
        setFilterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent MainActivityIntent = new Intent(FilterActivity.this, MainActivity.class);
                FilterActivity.this.startActivity(MainActivityIntent);
            }
        });
    }


    public void switchToHotelView(ImageButton btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent LoginActivityIntent = new Intent(FilterActivity.this, HotelViewActivity.class);
                FilterActivity.this.startActivity(LoginActivityIntent);

            }
        });
    }

    public void setPriceFilter(int min, int max){
        Log.d("0wnz0r", "button prezzored");
    }
}