package com.fission.sample.sharedloginexample;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lakshmi on 31/5/16.
 */
public class LoginActivity extends Activity {
    String userName;
    String password;
    //String userNameKey = "userNameKey";
    //String passwordKey = "passwordKey";
    SharedPreferences sharedPreferences;
    private EditText mUserNameEdt, mPasswordEdt;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences("preference", Context.MODE_PRIVATE);


        mUserNameEdt = (EditText) findViewById(R.id.edittext1);
        mPasswordEdt = (EditText) findViewById(R.id.edittext2);
        Button signUpbtn = (Button) findViewById(R.id.signUpbtn);
        Button loginBtn = (Button) findViewById(R.id.button1);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("preference", MODE_PRIVATE);
                userName = sharedPreferences.getString("userNameKey","");
                boolean output = sharedPreferences.contains("userNameKey");
                //String someValue = sharedPreferences.getString("userNameKey","someValue");
                //Log.e("A","someValue"+someValue);
                Log.e("A","key contains or not "+output);
                Log.e("A","key value "+userName);
                password = sharedPreferences.getString("passwordKey","");
                if(TextUtils.isEmpty(userName)){
                   Toast.makeText(getApplicationContext(), "Please register first", Toast.LENGTH_SHORT).show();
               }
               else if ((TextUtils.isEmpty(mUserNameEdt.getText())) || (!(mUserNameEdt.getText().toString().equals(userName)))) {
                    Toast.makeText(getApplicationContext(), "Please enterValidUsername", Toast.LENGTH_SHORT).show();

                } else if ((TextUtils.isEmpty(mPasswordEdt.getText())) || (!(mPasswordEdt.getText().toString().equals(password)))) {
                    Toast.makeText(getApplicationContext(), "Please enterValidPassword", Toast.LENGTH_SHORT).show();

                } else {
                    Toast.makeText(getApplicationContext(), "Entered UserName and Password are correct", Toast.LENGTH_SHORT).show();


                }



            }
        });

        signUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}