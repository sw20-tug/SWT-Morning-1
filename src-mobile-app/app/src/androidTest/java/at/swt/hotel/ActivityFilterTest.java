package at.swt.hotel;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ActivityFilterTest {

    private static final String MESSAGE = "Algarve";

    @Rule
    public ActivityTestRule<FilterActivity> activityRule
            = new ActivityTestRule<>(FilterActivity.class);

    @Test
    public void changeText_sameActivity() {

        onView(withId(R.id.editText))
                .perform(typeText(MESSAGE), closeSoftKeyboard());

        //onView(withId(R.id.send_message)).perform(click())

        // Type text and then press the button.
        //onView(withId(R.id.editTextUserInput))
        //        .perform(typeText(stringToBetyped), closeSoftKeyboard());
        //onView(withId(R.id.changeTextBt)).perform(click());

        // Check that the text was changed.
        //onView(withId(R.id.textToBeChanged))
        //        .check(matches(withText(stringToBetyped)));
    }
}