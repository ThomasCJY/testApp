package com.example.myapplication3;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.v("Bazel", "Hello, Android");

        setContentView(R.layout.activity_main);
    }
}
