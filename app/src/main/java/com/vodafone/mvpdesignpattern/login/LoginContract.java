package com.vodafone.mvpdesignpattern.login;

import android.content.Intent;

import com.vodafone.mvpdesignpattern.bases.BaseContract;
import com.vodafone.mvpdesignpattern.bases.BaseError;

/**
 * Created by Mohammad Sayed on 2/19/2018.
 */

public interface LoginContract {

    interface ILoginView extends BaseContract.IBaseView {
        void showLoadingProgress(boolean show);

        void displayErrorMessage(String message);

        void proceedToActivity(Intent intent);

        void onGetSettingsServiceSucceeded();

        void onLoginServiceSucceeded();
    }

    interface ILoginPresenter extends BaseContract.IBasePresenter {
        void getSettings();

        void login(String username, String password);

        void onSettingsRetrieved();

        void onLoginSucceeded();

        void onError(BaseError baseError);
    }

    interface ILoginRepository extends BaseContract.IBaseRepository {
        void getSettings();

        void startLoginService(String username, String password);
    }
}
