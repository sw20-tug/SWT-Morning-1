package at.swt.hotel;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        EditText editTextUserName = findViewById(R.id.editUserName);
        EditText editTextPassword = findViewById(R.id.editPassword);
        Button btnLogin           = findViewById(R.id.btn_login_loginactivity);
        switchToAdmin(editTextUserName, editTextPassword, btnLogin);

    }

    public void switchToAdmin(final EditText userName, final EditText password, final Button btn) {
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (userName.getText().toString().equals("admin")
                    && password.getText().toString().equals("password")) {
                    Intent LoginActivityIntent = new Intent(LoginActivity.this, MainActivity.class);
                    Bundle bundle = new Bundle();
                    bundle.putInt("VAL", 1);

                    LoginActivityIntent.putExtras(bundle);
                    startActivity(LoginActivityIntent);

                } else {
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(
                            context,
                            "Wrong username or password",
                            Toast.LENGTH_LONG);
                    toast.show();
                }


            }
        });
    }
}