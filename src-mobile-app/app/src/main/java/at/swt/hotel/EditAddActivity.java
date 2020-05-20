package at.swt.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class EditAddActivity extends AppCompatActivity {


    EditText name;
    EditText location;
    EditText price;
    EditText category;
    EditText description;
    RatingBar star;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_add);

        TextView headline = findViewById(R.id.activity_editadd);
        Button btn_editadd = findViewById(R.id.btn_editadd);
        name = findViewById(R.id.hotel_name_editadd);
        location = findViewById(R.id.hotel_location_editadd);
        price = findViewById(R.id.hotel_price_editadd);
        category = findViewById(R.id.hotel_category_editadd);
        description = findViewById(R.id.hotel_description_editadd);
        star = findViewById(R.id.hotel_star_editadd);


        Bundle bun = getIntent().getExtras();
        boolean add = bun.getBoolean("add");
        boolean edit = bun.getBoolean("edit");
        if(add) {
            headline.setText("Create Hotel");
            btn_editadd.setText("Add");

            // TODO: add the changed HotelContainer object to the bundle!
            switchToMainActivity(btn_editadd, false);
        }
        if(edit) {
            headline.setText("Edit Hotel");
            btn_editadd.setText("Edit");

            // TODO: add the changed HotelContainer object to the bundle!
            switchToMainActivity(btn_editadd, true);
        }
    }

    public void switchToMainActivity(Button btn, boolean edit_add) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("VAL", 1); //  TODO: change the value
                if(!edit_add) {



                    ArrayList<HotelPicture> pictures = new ArrayList<HotelPicture>();
                    pictures.add(new HotelPicture(99,99, R.drawable.hotel3_5));
                    HotelContainer hc = new HotelContainer(
                            new Hotel(
                                    99,
                                    name.getText().toString(),
                                    location.getText().toString(),
                                    Integer.parseInt(price.getText().toString()),
                                    category.getText().toString(),
                                    description.getText().toString(),
                                    null,
                                    star.getNumStars()),
                                    pictures,
                            null);
                    HotelProvider.getInstance().insertHotel(hc);
                } else {
                    // TODO: edit here!
                }

                Intent MainActivity = new Intent(EditAddActivity.this, at.swt.hotel.MainActivity.class);
                MainActivity.putExtras(bundle);
                startActivity(MainActivity);
                finish();
            }
        });
    }
}
