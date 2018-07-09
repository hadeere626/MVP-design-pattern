package com.vodafone.mvpdesignpattern.login;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.vodafone.mvpdesignparrern.R;
import com.vodafone.mvpdesignpattern.bases.BaseActivity;

public class LoginActivity extends BaseActivity<LoginPresenter> implements LoginContract.ILoginView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected LoginPresenter createPresenter() {
        return new LoginPresenter(this, this);
    }

    @Override
    public void showLoadingProgress(boolean show) {

    }

    @Override
    public void displayErrorMessage(String message) {

    }

    @Override
    public void proceedToActivity(Intent intent) {
        startActivity(intent);
    }

    @Override
    public void onGetSettingsServiceSucceeded() {

    }

    @Override
    public void onLoginServiceSucceeded() {

    }
}
