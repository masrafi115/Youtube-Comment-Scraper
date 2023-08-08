package com.masrafi115.ytcommscraper;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * This activity is used for completing the purpose to implement the functionality of splash screen
 * in the application
 */


// AppCompatActivity :- Base class for activities that wish to use some of the newer
// platform features on older Android devices.
public class SplashScreen extends AppCompatActivity {

    // time duration in which splashscreen will be shown when user will open the application and
    // after finishing SPLASH_TIME_OUT , another activity will be called
    private  static  int SPLASH_TIME_OUT = 3000;
    @Override
    /** onCreate(Bundle savedInstanceState) Function in Android: onCreate method is used to start/create an activity.
     * After Orientation changed then onCreate(Bundle savedInstanceState) will call and recreate
     * the activity and load all data from savedInstanceState.
     * Basically Bundle class is used to store the data of activity whenever above condition occur in app.
     */
    protected void onCreate(Bundle savedInstanceState) {
        // super is used to call the parent class constructor.
        super.onCreate(savedInstanceState);

        /**  setContentView() is a method part of "android.app.Activity class".
         * It helps to set our content or render our layout on the screen.
         * Based on the value given by the user, views will be inflated and rendered after the measurement of the screen, root view, and its child views.
         * "R" is an Java-class that is auto-generated from your resources by the build process.
         * The "R.layout" member is a auto-generated class that contains all IDs for layouts.
         */
        setContentView(R.layout.activity_splash_screen);


        /** Handler class :-  it is basically a message queue. You post a message to it,
         * and it will eventually process it by calling its run method and passing the message to it.
         * Since these run calls will always occur in the order of messages received on the same thread,
         * it allows you to serialize events.
         *
         * postDelayed :- Causes the Runnable r / new Runnable to be added to the message queue, to be run after the specified amount of time elapses.
         * The runnable will be run on the thread to which this handler is attached. The time-base is SystemClock.uptimeMillis().
         * Time spent in deep sleep will add an additional delay to execution.
         *
         * Runnable :-  This is an interface which should be implemented by any class whose instances are intended to be executed
         * by a thread. The class must define a method of no arguments called run .
         * This interface is designed to provide a common protocol for objects that wish to execute code while
         * they are active.
         */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Checking whether user is signed out or not .
                // If yes then start loginactivity otherwise start mainactivity
                // "check_login", this variable is declared and set in mainactivity so it is accessed
                // here by calling this variable through mainactivity.

                    Intent mainActivityIntent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(mainActivityIntent);
                    finish();
                
            }
        }, SPLASH_TIME_OUT );
    }
}