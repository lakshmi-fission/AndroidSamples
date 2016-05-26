package com.fission.sample.loginbutton;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity{
    Button loginButton,signUpbtn;
    EditText mUserNameEdt, mPasswordEdt;
     String string1=SignUpActivity.userName;
     String string2=SignUpActivity.password;

    @Override
    protected void onResume() {
        super.onResume();
        string1 = SignUpActivity.userName;
        string2 = SignUpActivity.password;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //final String string1= "lakshmi";
        //final String string2= "lakshmi";

        mUserNameEdt = (EditText)findViewById(R.id.edittext1);
        mPasswordEdt = (EditText) findViewById(R.id.edittext2);
        loginButton = (Button)findViewById(R.id.button1);
        signUpbtn=(Button) findViewById(R.id.signUpbtn);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if((TextUtils.isEmpty(mUserNameEdt.getText())) || (!(mUserNameEdt.getText().toString().equals(string1)))) {
                    Toast.makeText(getApplicationContext(),"Please enterValidUsername",Toast.LENGTH_SHORT).show();
                    //System.out.println("Please enter validusername");
                }

                else if((TextUtils.isEmpty(mPasswordEdt.getText())) || (!(mPasswordEdt.getText().toString().equals(string2)))) {
                    Toast.makeText(getApplicationContext(),"Please enterValidPassword",Toast.LENGTH_SHORT).show();
                    //System.out.println("Please enter validpassword");
                }
                else{
                    Toast.makeText(getApplicationContext(),"Entered UserName and Password are correct",Toast.LENGTH_SHORT).show();
                   // System.out.println("Entered username and password are correct");

                }


                }


//!(mUserNameEdt.getText().toString()).equals(string1) and  !mUserNameEdt.getText().toString().equals(string1) both are same
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
