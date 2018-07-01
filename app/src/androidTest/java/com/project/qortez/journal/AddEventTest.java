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
 */
@RunWith(AndroidJUnit4.class)
public class AddEventTest {

    @Rule
    public ActivityTestRule<MainActivity> mMainActivityActivityTestRule = new
            ActivityTestRule<>(MainActivity.class);

    @Test
    public void clickAddEventButton_opensAddEventUi() throws Exception {

        onView(withId(R.id.fab))
                .perform(click());
        onView(withId(R.id.editTextEventDescription))
                .check(matches(isDisplayed()));
    }


}
