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
public class PracticeActivity extends Activity{
    Button mbtnpractice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_layout);
        mbtnpractice = (Button) findViewById(R.id.btnpractice);
        mbtnpractice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PracticeActivity.this, Practice1Activity.class);
                startActivity(intent);

            }
        });

        Log.e("A", "P onCreate");
    }
        @Override
        protected void onStart () {
            super.onStart();
            System.out.println("Practice started");
            Log.e("A", "P onStart");

        }

        @Override
        protected void onRestart () {
            super.onRestart();
            System.out.println("Practice restarted");
            Log.e("A", "P onRestart");

        }

    @Override
    protected void onResume() {
        super.onResume();

        Log.e("A", "P onResume");

    }

    @Override
        protected void onPause () {
            super.onPause();
            System.out.println("Practice paused");
        Log.e("A", "P onPause");

    }

        @Override
        protected void onStop () {
            super.onStop();
            System.out.println("Practice stoped");

            Log.e("A", "P onStop");

        }

        @Override
        protected void onDestroy () {
            super.onDestroy();
            System.out.println("Practice destroyed");
            Log.e("A", "P onDestroy");

        }


    }

