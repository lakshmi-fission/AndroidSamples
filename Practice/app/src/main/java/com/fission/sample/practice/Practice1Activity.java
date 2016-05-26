package com.fission.sample.practice;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/**
 * Created by lakshmi on 23/5/16.
 */
public class Practice1Activity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.practice_layout);
        Button mbtnpractice = (Button) findViewById(R.id.btnpractice);
        mbtnpractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Practice1Activity.this, PracticeActivity.class);
                startActivity(intent);

            }
        });

        Log.e("A", "P1 onCreate");
    }
    @Override
    protected void onStart () {
        super.onStart();
        System.out.println("Practice started");
        Log.e("A", "P1 onStart");

    }

    @Override
    protected void onRestart () {
        super.onRestart();
        System.out.println("Practice restarted");
        Log.e("A", "P1 onRestart");

    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e("A", "P1 onResume");

    }

    @Override
    protected void onPause () {
        super.onPause();
        System.out.println("Practice paused");
        Log.e("A", "P1 onPause");

    }

    @Override
    protected void onStop () {
        super.onStop();
        System.out.println("Practice stoped");

        Log.e("A", "P1 onStop");

    }

    @Override
    protected void onDestroy () {
        super.onDestroy();
        System.out.println("Practice destroyed");
        Log.e("A", "P1 onDestroy");

    }

}
