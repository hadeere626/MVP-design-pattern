package com.vodafone.mvpdesignpattern.registration;

import android.content.Intent;

import com.vodafone.mvpdesignpattern.bases.BaseContract;
import com.vodafone.mvpdesignpattern.bases.BaseError;

/**
 * Created by Mohammad Sayed on 2/19/2018.
 */

public interface RegistrationContract {

    interface IRegisterView extends BaseContract.IBaseView {
        void showLoadingProgress(boolean show);

        void displayErrorMessage(String message);

        void proceedToActivity(Intent intent);


        void onRegisterServiceSucceeded();
    }

    interface IRegisterPresenter extends BaseContract.IBasePresenter {


        void Register(String username, String password);


        void onRegisterSucceeded();

        void onError(BaseError baseError);
    }

    interface IRegisterRepository extends BaseContract.IBaseRepository {


        void startRegisterService(String username, String password);
    }

}
