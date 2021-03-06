package ca.ualberta.cs.personal_condition_tracker;

import android.content.Intent;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.espresso.intent.Intents;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;
import ca.ualberta.cs.personal_condition_tracker.Activities.SignUpActivity;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

@RunWith(AndroidJUnit4.class)
public class SignUpActivityTest {
    @Rule
    public final ActivityTestRule<SignUpActivity> SignUpActivityRule = new ActivityTestRule<>(SignUpActivity.class, true, false);

    // Try adding a new patient to the app.
    @Test
    public void testAddNewPatient() throws Exception {
        Intents.init();
        SignUpActivityRule.launchActivity(new Intent());

        onView(withId(R.id.userIDText)).perform(typeText("Newer Patient")).perform(closeSoftKeyboard());

        onView(withId(R.id.signUpConfirmButton)).perform(click());

        intended(hasComponent(SignUpActivity.class.getName()));
        Intents.release();
    }

    // Try the cancel button.
    @Test
    public void testCancel() throws Exception {
        Intents.init();
        SignUpActivityRule.launchActivity(new Intent());

        onView(withId(R.id.signUpCancelButton)).perform(click());

        intended(hasComponent(SignUpActivity.class.getName()));
        Intents.release();
    }
}
