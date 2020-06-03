package at.swt.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class EditAddActivity extends AppCompatActivity {


    EditText name;
    EditText location;
    EditText price;
    EditText category;
    EditText description;
    RatingBar star;
    HotelContainer editHC;
    ImageView picture;
    TextView pictureError;
    Bitmap pictureToBeStored;

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
        picture = findViewById(R.id.image_editadd);
        pictureError = findViewById(R.id.image_editadd_error);

        Button loadPicture = findViewById(R.id.btn_image_editadd);
        loadPicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent()
                        .setType("*/*")
                        .setAction(Intent.ACTION_GET_CONTENT);

                startActivityForResult(Intent.createChooser(intent, "Select a file"), 9999);
            }
        });

        Bundle bun = getIntent().getExtras();
        boolean add = bun.getBoolean("add");
        boolean edit = bun.getBoolean("edit");
        if(add) {
            headline.setText("Create Hotel");
            btn_editadd.setText("Add");

            // TODO: add the changed HotelContainer object to the bundle!
            switchToMainActivity(btn_editadd, false);
        }
        if (edit) {
            headline.setText("Edit Hotel");
            btn_editadd.setText("Edit");

            for (HotelContainer hc : HotelProvider.getInstance().getHotelContainerList()) {
                if (hc.hotel.id == bun.getInt("HCId")) {
                    editHC = hc;
                    break;
                }
            }
            name.setText(editHC.hotel.name);
            star.setRating(editHC.hotel.stars);
            location.setText(editHC.hotel.location);
            price.setText(Integer.toString(editHC.hotel.price));
            category.setText(editHC.hotel.category);
            description.setText(editHC.hotel.description);
            switchToMainActivity(btn_editadd, true);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 9999 && resultCode == RESULT_OK) {
            try {
                pictureToBeStored = MediaStore.Images.Media.getBitmap(this.getContentResolver(), data.getData());
                picture.setImageBitmap(pictureToBeStored);
            } catch (IOException e)
            {
                pictureError.setError("Cannot load image: " + e.getMessage());
            }
        }
    }

    public void switchToMainActivity(Button btn, boolean edit_add) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("VAL", 1); //  TODO: change the value
                star.setRating(0);
                boolean error = false;

                if (name.getText().toString().isEmpty()) {
                    error = true;
                    name.setError("Name must not be empty");
                }

                if (location.getText().toString().isEmpty()) {
                    error = true;
                    location.setError("Location must not be empty");
                }

                if (category.getText().toString().isEmpty()) {
                    error = true;
                    category.setError("Category must not be empty");
                }

                if (description.getText().toString().isEmpty()) {
                    error = true;
                    description.setError("Description must not be empty");
                }

                if (price.getText().toString().isEmpty()) {
                    error = true;
                    price.setError("Price must not be empty");
                }

                if (error) {
                    return;
                }

                if(!edit_add) {



                    int hotelId = HotelProvider.getInstance().getNextHotelId();
                    ArrayList<HotelPicture> pictures = new ArrayList<HotelPicture>();
                    if (pictureToBeStored != null) {
                        ByteArrayOutputStream stream = new ByteArrayOutputStream();
                        pictureToBeStored.compress(Bitmap.CompressFormat.JPEG, 100, stream);
                        pictures.add(new HotelPicture(HotelProvider.getInstance().getNextPictureId(), hotelId, stream.toByteArray()));
                    }

                    HotelContainer hc = new HotelContainer(
                            new Hotel(
                                    hotelId,
                                    name.getText().toString(),
                                    location.getText().toString(),
                                    Integer.parseInt(price.getText().toString()),
                                    category.getText().toString(),
                                    description.getText().toString(),
                                    null,
                                    Math.round(star.getRating())),
                                    pictures,
                            null);
                    HotelProvider.getInstance().insertHotel(hc);
                } else {
                    editHC.hotel.name = name.getText().toString();
                    editHC.hotel.stars = Math.round(star.getRating());
                    editHC.hotel.location = location.getText().toString();
                    editHC.hotel.category = category.getText().toString();
                    editHC.hotel.description = description.getText().toString();
                    editHC.hotel.price = Integer.parseInt(price.getText().toString());
                    for (HotelContainer hc : HotelProvider.getInstance().getHotelContainerList()) {
                        if (hc.hotel.id == editHC.hotel.id) {
                            HotelProvider.getInstance().deleteHotel(hc);
                            HotelProvider.getInstance().insertHotel(editHC);
                            hc = editHC;
                            break;
                        }
                    }

                }

                Intent MainActivity = new Intent(EditAddActivity.this, at.swt.hotel.MainActivity.class);
                MainActivity.putExtras(bundle);
                startActivity(MainActivity);
                finish();
            }
        });
    }
}
