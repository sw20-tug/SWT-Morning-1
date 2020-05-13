package at.swt.hotel;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

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

    public void setPriceFilter(int min, int max) {
        List<HotelContainer> filteredHotels = new ArrayList<>();
        for(HotelContainer hc : HotelProvider.getInstance().getHotelContainerList()) {
 //           if (Integer.getInteger(hc.hotel.price) < max || Integer.getInteger(hc.hotel.price) > min) {
                filteredHotels.add(hc);
//           }
        }
        HotelProvider.getInstance().updateHotelList(filteredHotels);
    }
}