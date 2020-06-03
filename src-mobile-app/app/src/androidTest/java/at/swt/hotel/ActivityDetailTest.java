package at.swt.hotel;

import android.content.Intent;

import org.hamcrest.Matcher;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.intent.rule.IntentsTestRule;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ActivityDetailTest {

    private static final String MESSAGE = "This hotel blablablab...";

    @Rule
    public IntentsTestRule<MainActivity> activityRule
            = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void CheckActivity_DetailActivity() {

        onData(anything()).inAdapterView(withId(R.id.hotel_list)).atPosition(0).perform(click());
        intended(hasComponent(DetailActivity.class.getName()));

        onView(withId(R.id.txtHotelNameDetail))
                .check(matches(withText("Arte-Salzburg")));

    }


    @Test
    public void ActivitiesToggles_sameActivity() {

        onData(anything()).inAdapterView(withId(R.id.hotel_list)).atPosition(1).perform(click());
        intended(hasComponent(DetailActivity.class.getName()));

        onView(withId(R.id.txtPriceDetail))
                .check(matches(withText("95€")));

        onView(withId(R.id.txtLocationDetail))
                .check(matches(withText("Feld 2, 4853 Steinbach am Attersee")));
    }

}
