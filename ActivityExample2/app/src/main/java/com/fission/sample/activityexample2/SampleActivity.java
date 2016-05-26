package com.fission.sample.activityexample2;

import android.app.Activity;
import android.os.Bundle;

/**
 * Created by lakshmi on 18/5/16.
 */
public class SampleActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("created");
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("resume");
    }
    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("stoped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("destroyed");
    }
    protected void onPause() {
        super.onPause();
        System.out.println("pause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("restarted");
    }
}
