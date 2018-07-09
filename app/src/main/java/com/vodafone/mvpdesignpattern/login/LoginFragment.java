package com.vodafone.mvpdesignpattern.login;

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

/**
 * Created by Mohammad Sayed on 2/19/2018.
 */

public class LoginFragment extends Fragment implements LoginContract.ILoginView {

    EditText mEtUsername;
    EditText mEtPassword;
    Button mBtnLogin;
    TextView mTvRegister;
    ProgressBar mPbLoading;

    LoginPresenter mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        mEtUsername = view.findViewById(R.id.et_username);
        mEtPassword = view.findViewById(R.id.et_password);
        mBtnLogin = view.findViewById(R.id.btn_login);
        mTvRegister = view.findViewById(R.id.tv_register);
        mPbLoading = view.findViewById(R.id.pb_loading);

        mPresenter = new LoginPresenter(getContext(), this);
        mPresenter.getSettings();//Base Activity Function

        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.login(mEtUsername.getText().toString(), mEtPassword.getText().toString());
                //Base Activity Function
            }
        });

        mTvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mPresenter.openRegistrationScreen();
            }
        });
    }

    public void onLoginServiceSucceeded() {
        Toast.makeText(getContext(), "User Logged In", Toast.LENGTH_SHORT).show();
        mPbLoading.setVisibility(View.GONE);
    }

    public void onGetSettingsServiceSucceeded() {
        Toast.makeText(getContext(),"Settings Loaded Successfully", Toast.LENGTH_SHORT).show();
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
