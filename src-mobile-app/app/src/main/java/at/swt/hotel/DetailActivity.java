package at.swt.hotel;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.icu.text.StringPrepParseException;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class DetailActivity extends AppCompatActivity  {
    TextView name;
    RatingBar star;
    ImageView image;
    TextView description;
    TextView category;
    TextView activity;
    ListView hotelRating;
    TextView price;
    TextView location;
    String strActivity;



    HotelContainer editHC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Bundle bun = getIntent().getExtras();


        name = findViewById(R.id.txtHotelNameDetail);
        category = findViewById(R.id.categoryDetail);
        activity = findViewById(R.id.activityDetail);
        star = findViewById(R.id.ratingBarDetail);
        image = findViewById(R.id.imageViewDetail);
        description = findViewById(R.id.txtDescription);
        price = findViewById(R.id.txtPriceDetail);
        location = findViewById(R.id.txtLocationDetail);


        for (HotelContainer hc : HotelProvider.getInstance().getHotelContainerList()) {
            if (hc.hotel.id == bun.getInt("HCId")) {
                editHC = hc;
                break;
            }
        }
        name.setText(editHC.hotel.name);
        star.setRating(editHC.hotel.stars);
        //location.setText(editHC.hotel.location);
        //Bitmap bitmap = BitmapFactory.decodeByteArray(editHC.hotel.thumbnail, 0, editHC.hotel.thumbnail.length);
        //image.setImageBitmap(bitmap);
        int position = bun.getInt("Pos");
        int picture = editHC.hotelpictures.get(0).picture;
        Log.d("POS", "Position: " + position);
        if (picture == 0) {
            picture = R.drawable.hotel3_5;
        }
        image.setImageResource(picture);
        price.setText(Integer.toString(editHC.hotel.price) + "€");
        location.setText(editHC.hotel.location);
        description.setText(editHC.hotel.description);
        category.setText(editHC.hotel.category);
        strActivity = new String();
        if (editHC.hotelinterest != null) {
            for (HotelInterest interest : editHC.hotelinterest) {
                strActivity += interest.type;
                strActivity += "\n";
            }
        }

        activity.setText(strActivity);
    }



}
