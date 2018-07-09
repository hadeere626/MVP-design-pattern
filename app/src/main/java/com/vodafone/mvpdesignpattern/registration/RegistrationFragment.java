package com.vodafone.mvpdesignpattern.registration;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vodafone.mvpdesignparrern.R;
import com.vodafone.mvpdesignpattern.login.LoginPresenter;

/**
 * Created by Mohammad Sayed on 2/19/2018.
 */

public class RegistrationFragment extends Fragment implements RegistrationContract.IRegisterView {

    EditText mEtUsername;
    EditText mEtPassword;
    Button mBtnRegister;
    ProgressBar mPbLoading;

    RegistrationPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_registration, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mEtUsername = view.findViewById(R.id.et_username);
        mEtPassword = view.findViewById(R.id.et_password);
        mBtnRegister = view.findViewById(R.id.btn_register);
        mPbLoading = view.findViewById(R.id.pb_loading);

        mPresenter = new RegistrationPresenter(getContext(), this);

        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.Register(mEtUsername.getText().toString(), mEtPassword.getText().toString());
                //Base Activity Function
            }
        });


    }

    public void onRegisterServiceSucceeded() {
        Toast.makeText(getContext(), "User Registered ", Toast.LENGTH_SHORT).show();
        mPbLoading.setVisibility(View.GONE);
    }


    //--------------------------------
    @Override
    public void showLoadingProgress(boolean show) {
        if (show) {
            mPbLoading.setVisibility(View.VISIBLE);
        } else {
            mPbLoading.setVisibility(View.GONE);
        }
    }

    @Override
    public void displayErrorMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
        mPbLoading.setVisibility(View.GONE);
    }

    @Override
    public void proceedToActivity(Intent intent) {
        startActivity(intent);
    }

}
