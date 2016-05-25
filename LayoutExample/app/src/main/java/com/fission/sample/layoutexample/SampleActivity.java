package com.fission.sample.layoutexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by lakshmi on 19/5/16.
 */
public class SampleActivity extends Activity {


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);
        Button btn;
        final TextView textView;
        btn = (Button)findViewById(R.id.button);
        textView = (TextView)findViewById(R.id.txt);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("buttonclicked");
                System.out.println(textView.getText());

            }
        });
    }}

