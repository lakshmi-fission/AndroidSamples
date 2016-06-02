package com.fission.sample.sharedpreferencesexample;

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
        String userNameKey;
        String passwordKey;
        String loginKey;
        boolean login1;
        private EditText mUserNameEdt,mPasswordEdt;
       SharedPreferences sharedPreferences;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        sharedPreferences = getSharedPreferences("preference", Context.MODE_PRIVATE);
        login1 = sharedPreferences.getBoolean("loginKey", false);
        if (login1) {
        } else {
            Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
            //SharedPreferences.Editor editor1 = sharedPreferences.edit();
            //editor1.putBoolean("loginKey",true);
            //editor1.commit();
            startActivity(intent);
        }

        mUserNameEdt = (EditText) findViewById(R.id.edittext1);
        mPasswordEdt = (EditText) findViewById(R.id.edittext2);
        Button signUpbtn = (Button) findViewById(R.id.signUpbtn);
        signUpbtn.setVisibility(View.INVISIBLE);
        Button loginBtn = (Button) findViewById(R.id.button1);
        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getSharedPreferences("preference", MODE_PRIVATE);
                userName = sharedPreferences.getString(userNameKey, "");
                password = sharedPreferences.getString(passwordKey, "");
                //Log.e("storedUsername",userName);
                //Log.e("storedPassword",password);
                if ((TextUtils.isEmpty(mUserNameEdt.getText())) || (!(mUserNameEdt.getText().toString().equals(userName)))) {
                    Toast.makeText(getApplicationContext(), "Please enterValidUsername", Toast.LENGTH_SHORT).show();
                    //System.out.println("Please enter validusername");
                } else if ((TextUtils.isEmpty(mPasswordEdt.getText())) || (!(mPasswordEdt.getText().toString().equals(password)))) {
                    Toast.makeText(getApplicationContext(), "Please enterValidPassword", Toast.LENGTH_SHORT).show();
                    //System.out.println("Please enter validpassword");
                } else {
                    Toast.makeText(getApplicationContext(), "Entered UserName and Password are correct", Toast.LENGTH_SHORT).show();
                    // System.out.println("Entered username and password are correct");

                }


                //Log.e("storedUsername",userName);
                //Log.e("storedPassword",password);
            }
        });

        /*signUpbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });*/

    }
}