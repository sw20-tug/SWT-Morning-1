package at.swt.hotel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

public class DataInitializer extends AppCompatActivity {

    /* The name of the data base. */
    public static final String DB_NAME = "Hotel_db";

    public void init() {
        AppDatabase db = Room.databaseBuilder(
                getApplicationContext(),
                AppDatabase.class,
                DB_NAME).build();

        //TODO: fill database like this
        //db.userDao().insertAll();
    }
}
