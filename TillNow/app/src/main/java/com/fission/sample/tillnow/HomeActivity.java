package com.fission.sample.tillnow;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by lakshmi on 5/6/16.
 */
public class HomeActivity extends Fragment {
    Button homeBtn;
    @Override
    public android.view.View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View homeView = inflater.inflate(R.layout.home_fragment,container,false);
        homeBtn =(Button)homeView.findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences sharedPreferences = getActivity().getSharedPreferences("preference", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("isLogin",true);
                editor.commit();
                FragmentManager fragmentManager= getFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                ListViewFragment listViewFragment = new ListViewFragment();
                fragmentTransaction.replace(R.id.container,listViewFragment);
                fragmentTransaction.commit();
            }
        });
       return homeView;

    }
}
