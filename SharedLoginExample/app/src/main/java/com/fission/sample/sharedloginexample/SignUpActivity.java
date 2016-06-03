package com.fission.sample.sharedloginexample;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {
    Button submitBtn;
    EditText muserNameEdt, mpasswordEdt, confirmPasswordEdt;
    //String userNameKey = "userNameKey";
    //String passwordKey = "passwordKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        submitBtn = (Button) findViewById(R.id.signUpSubmit);
        muserNameEdt = (EditText) findViewById(R.id.usernameEdt);
        mpasswordEdt = (EditText) findViewById(R.id.passwordEdt);
        confirmPasswordEdt = (EditText) findViewById(R.id.confirmpassword);
        final SharedPreferences sharedPreference = getSharedPreferences("preference", MODE_PRIVATE);
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((TextUtils.isEmpty(muserNameEdt.getText())) || (TextUtils.isEmpty(mpasswordEdt.getText())) || (TextUtils.isEmpty(confirmPasswordEdt.getText()))) {
                    Toast.makeText(getApplicationContext(), "Please EnterAllfields", Toast.LENGTH_SHORT).show();
                } else if (mpasswordEdt.getText().toString().equals(confirmPasswordEdt.getText().toString())) {
                    String username = muserNameEdt.getText().toString();
                    String password = mpasswordEdt.getText().toString();
                    SharedPreferences.Editor editor = sharedPreference.edit();
                    editor.putString("userNameKey", username);
                    editor.putString("passwordKey", password);
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Details successfully submitted", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(SignUpActivity.this,LoginActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Please enter details correctly", Toast.LENGTH_SHORT).show();
                }
                finish();
            }
        });
    }
}
