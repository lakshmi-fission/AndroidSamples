package com.fission.sample.loginbutton;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lakshmi on 20/5/16.
 */
public class SignUpActivity extends Activity {
    Button submitBtn;
    EditText userNameEdt,passwordEdt,confirmPasswordEdt;
    static String userName,password;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        submitBtn=(Button)findViewById(R.id.signUpSubmit);
        userNameEdt=(EditText)findViewById(R.id.usernameEdt) ;
        passwordEdt=(EditText)findViewById(R.id.passwordEdt);
        confirmPasswordEdt=(EditText)findViewById(R.id.confirmpassword);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if((TextUtils.isEmpty(userNameEdt.getText())) || (TextUtils.isEmpty(passwordEdt.getText())) || (TextUtils.isEmpty(confirmPasswordEdt.getText()))){
                    Toast.makeText(getApplicationContext(),"Please EnterAllfields",Toast.LENGTH_SHORT).show();
                }
                else if(passwordEdt.getText().toString().equals(confirmPasswordEdt.getText().toString())){
                    userName=userNameEdt.getText().toString();
                    password=passwordEdt.getText().toString();
                    Toast.makeText(getApplicationContext(),"Details successfully submitted",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please enter details correctly",Toast.LENGTH_SHORT).show();
                }

            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("Second activity started");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("Second activity restarted");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("Second activity resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("Second activity paused");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("Second activity destroyed");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("Second activity stoped");
    }

}
