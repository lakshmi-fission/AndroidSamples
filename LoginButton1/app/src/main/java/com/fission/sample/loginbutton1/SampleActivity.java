package com.fission.sample.loginbutton1;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SampleActivity extends Activity implements View.OnClickListener{
    Button btnLogin,btnSubmit;
    EditText mUserNameEdt,mPasswordEdt;
    String string1 = "lakshmi";
    String string2 = "lakshmi";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginbuttonlayout);
        btnLogin  = (Button) findViewById(R.id.loginbutton);
        btnSubmit = (Button) findViewById(R.id.submitbutton);
        mUserNameEdt = (EditText) findViewById(R.id.edittext1);
        mPasswordEdt = (EditText) findViewById(R.id.edittext2);
        btnLogin.setOnClickListener(this);
        btnSubmit.setOnClickListener(this);


    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.loginbutton:
                if ((TextUtils.isEmpty(mUserNameEdt.getText())) || (!(mUserNameEdt.getText().toString().equals(string1)))) {
                    System.out.println("Please enter validusername");
                } else if ((TextUtils.isEmpty(mPasswordEdt.getText())) || (!(mPasswordEdt.getText().toString().equals(string2)))) {
                    System.out.println("Please enter validpassword");
                } else {
                    System.out.println("Entered username and password are correct");

                }
                break;
            case R.id.submitbutton:
                System.out.println("Submited");
                break;

        }
     }

}
