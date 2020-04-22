package at.swt.hotel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ImageButton btnBack = findViewById(R.id.btn_back_main);
        switchToMainView(btnBack);


    }
    public void switchToMainView(ImageButton btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainActivityIntent = new Intent(AdminActivity.this, MainActivity.class);
                AdminActivity.this.startActivity(MainActivityIntent);
                Context context = getApplicationContext();
                Toast toast = Toast.makeText(
                        context,
                        "All changes are saved",
                        Toast.LENGTH_LONG);
                toast.show();


            }
        });
    }
}
