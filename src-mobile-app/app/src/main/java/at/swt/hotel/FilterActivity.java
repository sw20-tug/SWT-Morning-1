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

    List<HotelContainer> priceFilteredHotels;
    List<HotelContainer> starFilteredHotels;
    List<HotelContainer> activityFilteredHotels;
    List<HotelContainer> categoryFilteredHotels;
    List<HotelContainer> locationFilteredHotels;
    boolean pirceFiler = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        ImageButton btnSearch = findViewById(R.id.btnFilterSearch);
        switchToHotelView(btnSearch);
        pirceFiler = false;

        HotelProvider.getInstance().resetHotelList();
        priceFilteredHotels = new ArrayList<>();
        starFilteredHotels = new ArrayList<>();
        starFilteredHotels.addAll(HotelProvider.getInstance().getHotelContainerList());
        activityFilteredHotels = new ArrayList<>();
        activityFilteredHotels.addAll(HotelProvider.getInstance().getHotelContainerList());
        categoryFilteredHotels = new ArrayList<>();
        categoryFilteredHotels.addAll(HotelProvider.getInstance().getHotelContainerList());
        locationFilteredHotels = new ArrayList<>();
        locationFilteredHotels.addAll(HotelProvider.getInstance().getHotelContainerList());

        Button priceButton0_50 = findViewById(R.id.priceToggle1);
        priceButton0_50.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                setPriceFilter(0, 50);
            }
        });

        Button priceButton50_100 = findViewById(R.id.priceToggle2);
        priceButton50_100.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setPriceFilter(50, 100);
            }
        });

        Button priceButton100_150 = findViewById(R.id.priceToggle3);
        priceButton100_150.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setPriceFilter(100, 150);
            }
        });

        Button priceButton150_200 = findViewById(R.id.priceToggle4);
        priceButton150_200.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setPriceFilter(150, 200);
            }
        });

        Button priceButton200 = findViewById(R.id.priceToggle5);
        priceButton200.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                setPriceFilter(200, 999999);
            }
        });


        Button setFilterButton = findViewById(R.id.applyFilterButton);
        setFilterButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                List<HotelContainer> filteredHotels = priceFilteredHotels;
                if (priceFilteredHotels.isEmpty() && !pirceFiler) {
                    filteredHotels = HotelProvider.getInstance().getHotelContainerList();
                }
                filteredHotels.retainAll(starFilteredHotels);
                filteredHotels.retainAll(activityFilteredHotels);
                filteredHotels.retainAll(categoryFilteredHotels);
                filteredHotels.retainAll(locationFilteredHotels);
                HotelProvider.getInstance().updateHotelList(filteredHotels); //TODO calculate Schnittmenge
                Intent mainActivityIntent = new Intent(FilterActivity.this, MainActivity.class);
                FilterActivity.this.startActivity(mainActivityIntent);
            }
        });
    }

    public void switchToHotelView(ImageButton btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hotelViewActivity = new Intent(FilterActivity.this, HotelViewActivity.class);
                FilterActivity.this.startActivity(hotelViewActivity);

            }
        });
    }

    public void setPriceFilter(final int min, final int max) {
        pirceFiler = true;
        for(HotelContainer hc : HotelProvider.getInstance().getHotelContainerList()) {
           if (hc.hotel.price <= max && hc.hotel.price >= min) {
               priceFilteredHotels.add(hc);
           }
        }
    }
}