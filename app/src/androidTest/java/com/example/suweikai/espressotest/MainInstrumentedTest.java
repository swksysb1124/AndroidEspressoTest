package com.example.suweikai.espressotest;

import android.support.test.espresso.ViewAction;
import android.support.test.espresso.action.ViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.clearText;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isEnabled;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainInstrumentedTest {

    private String[] textTestCase = {"hello", "there", "welcome", "to" ,"use", "espresso"};

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule
            = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void typeText() throws InterruptedException {
        for(String text: textTestCase) {
            onView(withId(R.id.editTextUserInput))
                    .perform(ViewActions.typeText(text), closeSoftKeyboard());
            rest();
            onView(withId(R.id.editTextUserInput))
                    .perform(clearText());
        }
        Thread.sleep(2000);
    }

    @Test
    public void clickButton() throws InterruptedException {
        onView(withId(R.id.changeTextBt)).perform(click());
        Thread.sleep(2000);
    }

    @Test
    public void typeAndClick() throws InterruptedException{
        for(String text: textTestCase) {
            onView(withId(R.id.editTextUserInput))
                    .perform(ViewActions.typeText(text), closeSoftKeyboard());
            rest();
            onView(withId(R.id.changeTextBt)).perform(click());
        }
        Thread.sleep(5000);
    }

    public void rest() throws InterruptedException {
        Thread.sleep(3 * 500);
    }

    @Test
    public void wholeTest() throws InterruptedException {
        for(String text: textTestCase) {
            onView(withId(R.id.editTextUserInput))
                    .perform(ViewActions.typeText(text), closeSoftKeyboard());
            rest();
            onView(withId(R.id.changeTextBt)).perform(click());
        }
        Thread.sleep(2000);
        onView(withId(R.id.btn_next)).perform(click());
        onView(withId(R.id.editTextUserInput)).perform(ViewActions.typeText("AAAAA"), closeSoftKeyboard());
        rest();
        onView(withId(R.id.btn_back)).perform(click());
        onView(withId(R.id.btn_next)).check(matches(isEnabled()));
    }
}
