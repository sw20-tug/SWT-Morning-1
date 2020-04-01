package at.swt.hotel;

<<<<<<< HEAD
=======
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
>>>>>>> HOTEL_001A
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.ColumnInfo;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.Delete;
import androidx.room.Entity;
import androidx.room.Insert;
import androidx.room.PrimaryKey;
import androidx.room.Query;
import androidx.room.Room;
import androidx.room.RoomDatabase;

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