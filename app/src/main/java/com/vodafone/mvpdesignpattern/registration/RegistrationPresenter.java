package com.vodafone.mvpdesignpattern.registration;

import android.content.Context;
import android.content.Intent;

import com.vodafone.mvpdesignpattern.bases.BaseError;
import com.vodafone.mvpdesignpattern.bases.BasePresenter;
import com.vodafone.mvpdesignpattern.login.LoginContract;
import com.vodafone.mvpdesignpattern.login.LoginRepository;

/**
 * Created by Mohammad Sayed on 2/18/2018.
 */

public class RegistrationPresenter extends BasePresenter<RegistrationContract.IRegisterView, RegistrationContract.IRegisterRepository>
        implements RegistrationContract.IRegisterPresenter {

    public RegistrationPresenter(Context context, RegistrationContract.IRegisterView view) {
        super(context, view);
    }

    @Override
    protected RegistrationRepository createRepository() {
        return new RegistrationRepository(this);
    }




    @Override
    public void Register(String username, String password) {
        getView().showLoadingProgress(true);
        getRepository().startRegisterService(username, password);
    }



    @Override
    public void onRegisterSucceeded() {
        getView().onRegisterServiceSucceeded();
        getView().showLoadingProgress(false);
    }

    @Override
    public void onError(BaseError baseError) {
        getView().displayErrorMessage(baseError.getMessage());
    }
}
