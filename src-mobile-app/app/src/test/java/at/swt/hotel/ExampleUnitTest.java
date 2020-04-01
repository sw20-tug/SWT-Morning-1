package at.swt.hotel;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }


    @Test
    public void addUserToDBTest()
    {
        DataInitializer da = new DataInitializer();
        AppDatabase db = da.init();

        User testUser = new User();
        testUser.name = "test Hans";
        testUser.email = "testmail@tugraz.at";

        db.userDao().insertAll(testUser);
    }
}

