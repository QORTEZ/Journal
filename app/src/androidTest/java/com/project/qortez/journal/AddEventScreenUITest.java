package com.project.qortez.journal;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Created by ${Qortez} on 6/30/2018.
 * <p>
 * This is a UI test using espresso which checks if the edit text on AddEventActivity is
 * displayed when the Activity is launched
 */
@RunWith(AndroidJUnit4.class)
public class AddEventScreenUITest {

    // Rule to launch the MainActivity
    @Rule
    public ActivityTestRule<MainActivity> mMainActivityTestRule = new
            ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickAddEventButton_opensAddEventUi() throws Exception {
        //Find floating action button on MainActivity and perform Onclick action to launch
        //AddEventActivity
        onView(withId(R.id.fab))
                .perform(click());
        //Find the eventDescription edit text and check whether its displayed
        onView(withId(R.id.editTextEventDescription))
                .check(matches(isDisplayed()));
    }


}
