package at.swt.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button startTutorials = (Button) findViewById(R.id.btn_sort);
        startTutorials.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tutorialsActivityIntent = new Intent(MainActivity.this, HotelViewActivity.class);
                MainActivity.this.startActivity(tutorialsActivityIntent);

            }
        });

    }
}
