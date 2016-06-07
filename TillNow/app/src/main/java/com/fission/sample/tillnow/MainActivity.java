package com.fission.sample.tillnow;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity{
    SharedPreferences sharedPreferences;
    boolean login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sharedPreferences = getSharedPreferences("preference", Context.MODE_PRIVATE);
        login = sharedPreferences.getBoolean("isLogin",false);
        if(login){
            FragmentManager fragmentManager = getFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            ListViewFragment listViewFragment = new ListViewFragment();
            fragmentTransaction.add(R.id.container,listViewFragment);
            fragmentTransaction.commit();
        }
        else{
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        LoginFragment loginFragment= new LoginFragment();
        fragmentTransaction.add(R.id.container,loginFragment);
        fragmentTransaction.commit();}
    }
}
