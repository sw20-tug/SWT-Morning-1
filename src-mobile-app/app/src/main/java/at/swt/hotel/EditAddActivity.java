package at.swt.hotel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EditAddActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_add);

        TextView headline = findViewById(R.id.activity_editadd);
        Button btn_editadd = findViewById(R.id.btn_editadd);


        Bundle bun = getIntent().getExtras();
        boolean add = bun.getBoolean("add");
        boolean edit = bun.getBoolean("edit");
        if(add) {
            headline.setText("Create Hotel");
            btn_editadd.setText("Add");
            // TODO: add the changed HotelContainer object to the bundle!
            switchToMainActivity(btn_editadd);
        }
        if(edit) {
            headline.setText("Edit Hotel");
            btn_editadd.setText("Edit");

            // TODO: add the changed HotelContainer object to the bundle!
            switchToMainActivity(btn_editadd);
        }
    }

    public void switchToMainActivity(Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = new Bundle();
                bundle.putInt("VAL", 1); //  TODO: change the value
                Intent MainActivity = new Intent(EditAddActivity.this, at.swt.hotel.MainActivity.class);
                MainActivity.putExtras(bundle);
                startActivity(MainActivity);
                finish();
            }
        });
    }
}
