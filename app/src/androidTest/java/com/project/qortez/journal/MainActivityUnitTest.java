package com.project.qortez.journal;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created by ${Qortez} on 7/1/2018.
 * <p>
 * This is unit test for MainActivity to check if it is launched or not
 */
public class MainActivityUnitTest {

    //  Rule for launching the Activity
    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);
    // Reference to the activity
    private MainActivity mActivity = null;

    @Before
    public void setUp() throws Exception {
        //Get activity
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLaunch() {
        //find view displayed on MainActivity
        View view = mActivity.findViewById(R.id.recyclerViewTasks);
        //check if the the view is not null
        assertNotNull(view);

    }

    @After
    public void tearDown() throws Exception {
        //clean up
        mActivity = null;
    }
}