package at.swt.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class FilterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);
        ImageButton btnSearch = findViewById(R.id.btnFilterSearch);
        switchToHotelView(btnSearch);
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
}