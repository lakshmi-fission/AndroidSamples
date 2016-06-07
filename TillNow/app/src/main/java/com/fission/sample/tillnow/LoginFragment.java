package com.fission.sample.tillnow;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lakshmi on 5/6/16.
 */
public class LoginFragment extends Fragment {
    Button mLoginBtn,mSinUpBtn;
    private EditText mLoginUserNameEdt,mLoginpasswordEdt;
    ExampleDBHelper loginDetails;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        final View rootView = inflater.inflate(R.layout.login_fragment,container,false);
        loginDetails = new ExampleDBHelper(getActivity());
        mLoginBtn=(Button)rootView.findViewById(R.id.button1);
        mSinUpBtn = (Button)rootView.findViewById(R.id.signUpbtn);
        mSinUpBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             FragmentManager fragmentManager= getFragmentManager();
                                             FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                                             SignUpFragment signUpFragment = new SignUpFragment();
                                             fragmentTransaction.replace(R.id.container,signUpFragment);
                                             fragmentTransaction.commit();
                                         }
                                     });

                mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mLoginUserNameEdt =(EditText)rootView.findViewById(R.id.edittext1);
                mLoginpasswordEdt = (EditText)rootView.findViewById(R.id.edittext2);
                Cursor res=loginDetails.getSingleEntry(mLoginUserNameEdt.getText().toString());
                Log.e("A", "count = "+res.getCount());
                if(res.getCount()==0)
                {
                    Toast.makeText(getActivity(),"signup first",Toast.LENGTH_SHORT).show();
                }
               else{
                    res.moveToFirst();
                    String userName = res.getString(res.getColumnIndex(ExampleDBHelper.COLUM_USERNAME));
                    String password = res.getString(res.getColumnIndex(ExampleDBHelper.COLUM_PASSWORD));
                if((TextUtils.isEmpty(mLoginUserNameEdt.getText())) || (!(mLoginUserNameEdt.getText().toString().equals(userName)))) {
                    Toast.makeText(getActivity(),"Please enterValidUsername",Toast.LENGTH_SHORT).show();

                }

                else if((TextUtils.isEmpty(mLoginpasswordEdt.getText())) || (!(mLoginpasswordEdt.getText().toString().equals(password)))) {
                    Toast.makeText(getActivity(),"Please enterValidPassword",Toast.LENGTH_SHORT).show();

                }
                else{
                    Toast.makeText(getActivity(),"Entered UserName and Password are correct",Toast.LENGTH_SHORT).show();
                    FragmentManager fragmentManager = getFragmentManager();
                    FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                    HomeActivity homeFragment = new HomeActivity();
                    fragmentTransaction.replace(R.id.container,homeFragment);
                    fragmentTransaction.commit();


                }}


            }
        });

        return rootView;
    }
}
