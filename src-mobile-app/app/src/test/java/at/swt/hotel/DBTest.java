package at.swt.hotel;

import android.content.Context;

import androidx.room.Room;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

//@RunWith(AndroidJUnit4.class)
public class DBTest{

    private UserDao userDao;
    private AppDatabase db;
    private Context ApplicationProvider;
    public static final String DB_NAME = "Hotel_db";

    @Before
    public void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        db = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        //userDao = db.getUserDao();
    }

    @After
    public void closeDb() throws IOException {
        db.close();
    }

    @Test
    public void writeUserAndReadInList() throws Exception {
        //DataInitializer da = new DataInitializer();
        //AppDatabase db = da.init();

        User testUser = new User();
        testUser.name = "test Hans";
        testUser.email = "testmail@tugraz.at";

        db.userDao().insertAll(testUser);
        List<User> byName = db.userDao().getAll();
        //List<User> byName = userDao.findUsersByName("george");
        assertThat(byName.get(0), equalTo(testUser));
    }
}
