package com.fission.sample.activityexample1;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lakshmi on 18/5/16.
 */
public class SampleActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.mylayout);

        Button btn = (Button) findViewById(R.id.clickbutton);
        TextView txtview = (TextView) findViewById(R.id.textView);

        txtview.setText("mytest");

        btn.setText("MAIN");
       /* btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(),"CLicked",Toast.LENGTH_SHORT).show();
            }
        });


    }

}
