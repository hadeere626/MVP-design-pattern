package com.vodafone.mvpdesignpattern.login;

import android.content.Context;
import android.content.Intent;

import com.vodafone.mvpdesignpattern.bases.BaseError;
import com.vodafone.mvpdesignpattern.bases.BasePresenter;
import com.vodafone.mvpdesignpattern.registration.RegistrationActivity;

/**
 * Created by Mohammad Sayed on 2/18/2018.
 */

public class LoginPresenter extends BasePresenter<LoginContract.ILoginView, LoginContract.ILoginRepository>
        implements LoginContract.ILoginPresenter {

    public LoginPresenter(Context context, LoginContract.ILoginView view) {
        super(context, view);
    }

    @Override
    protected LoginRepository createRepository() {
        return new LoginRepository(this);
    }

    public void openRegistrationScreen() {
        Intent intent = new Intent(getContext(), RegistrationActivity.class);
        getView().proceedToActivity(intent);
    }


    //---------------

    @Override
    public void getSettings() {
        getView().showLoadingProgress(true);
        getRepository().getSettings();
    }

    @Override
    public void login(String username, String password) {
        getView().showLoadingProgress(true);
        getRepository().startLoginService(username, password);
    }

    @Override
    public void onSettingsRetrieved() {
        getView().onGetSettingsServiceSucceeded();
        getView().showLoadingProgress(false);
    }

    @Override
    public void onLoginSucceeded() {
        getView().onLoginServiceSucceeded();
        getView().showLoadingProgress(false);
    }

    @Override
    public void onError(BaseError baseError) {
        getView().displayErrorMessage(baseError.getMessage());
    }
}
