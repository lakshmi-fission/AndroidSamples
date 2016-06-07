package com.fission.sample.tillnow;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by lakshmi on 5/6/16.
 */
public class SignUpFragment extends Fragment {
    EditText mSignUpuserNameEdt,mSignUppaswordEdt,mConfirmPasseordEdt;
    Button msubmitBtn;
    ExampleDBHelper signUpDetails;
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {
        View signUpRootView = inflater.inflate(R.layout.signup_fragment, container, false);
        signUpDetails = new ExampleDBHelper(getActivity());
        mSignUpuserNameEdt = (EditText) signUpRootView.findViewById(R.id.usernameEdt);
        mSignUppaswordEdt = (EditText) signUpRootView.findViewById(R.id.confirmpasswordEdt);
        mConfirmPasseordEdt = (EditText) signUpRootView.findViewById(R.id.passwordEdt);
        msubmitBtn = (Button) signUpRootView.findViewById(R.id.signUpSubmit);
        msubmitBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                String signUpUserName = mSignUpuserNameEdt.getText().toString();
                String signUpPassword = mSignUppaswordEdt.getText().toString();
                String confirmPassword = mConfirmPasseordEdt.getText().toString();
                if ((TextUtils.isEmpty(signUpUserName) || (TextUtils.isEmpty(signUpPassword)) || (TextUtils.isEmpty(confirmPassword)))) {
                    Toast.makeText(getActivity(), "Please EnterAllfields", Toast.LENGTH_SHORT).show();
                }
                else if (signUpPassword.equals(confirmPassword)) {
                    boolean inserted = signUpDetails.insertData(signUpUserName, signUpPassword);
                    if(inserted){
                        Toast.makeText(getActivity(), "Details successfully submitted", Toast.LENGTH_SHORT).show();
                        FragmentManager fragmentManager = getFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        LoginFragment loginFragment = new LoginFragment();
                        fragmentTransaction.replace(R.id.container,loginFragment);
                        fragmentTransaction.commit();
                    }
                    else{
                        Toast.makeText(getActivity(), "Duplicate data not allowed ", Toast.LENGTH_SHORT).show();
                    }


                }
                else {
                    Toast.makeText(getActivity(), "Please enter details correctly", Toast.LENGTH_SHORT).show();
                }

            }



        });

        return signUpRootView;

    }
}
