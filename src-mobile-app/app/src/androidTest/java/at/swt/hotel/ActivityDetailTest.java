package at.swt.hotel;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isChecked;
import static androidx.test.espresso.matcher.ViewMatchers.isNotChecked;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ActivityDetailTest {


    @Rule
    public ActivityTestRule<DetailActivity> activityRule
            = new ActivityTestRule<>(DetailActivity.class);

    @Test
    public void CategoryToggles_sameActivity() {
        onView(withId(R.id.categoryToggle1Detail))
                .perform(click());
        onView(withId(R.id.categoryToggle1Detail))
                .check(matches(isChecked()));

        onView(withId(R.id.categoryToggle2Detail))
                .perform(click());
        onView(withId(R.id.categoryToggle2Detail))
                .check(matches(isChecked()));

        onView(withId(R.id.categoryToggle3Detail))
                .perform(click());
        onView(withId(R.id.categoryToggle3Detail))
                .check(matches(isChecked()));

        onView(withId(R.id.categoryToggle4Detail))
                .perform(click());
        onView(withId(R.id.categoryToggle4Detail))
                .check(matches(isChecked()));
    }
}
