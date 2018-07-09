package com.vodafone.mvpdesignpattern.login;

import com.vodafone.mvpdesignpattern.bases.BaseError;
import com.vodafone.mvpdesignpattern.bases.BaseRepository;
import com.vodafone.mvpdesignpattern.bases.OnServiceFailedListener;
import com.vodafone.mvpdesignpattern.bases.OnServiceSuccessListener;

/**
 * Created by Mohammad Sayed on 2/18/2018.
 */

public class LoginRepository extends BaseRepository<LoginContract.ILoginPresenter>
        implements LoginContract.ILoginRepository {

    private LoginService mLoginService;

    public LoginRepository(LoginPresenter loginPresenter) {
        super(loginPresenter);
    }

    public void startLoginService(String username, String password) {
        if (mLoginService == null) {
            OnServiceSuccessListener onServiceSuccessListener = new OnServiceSuccessListener() {
                @Override
                public void onSuccess() {
                    getPresenter().onLoginSucceeded();
                }
            };

            OnServiceFailedListener onServiceFailedListener = new OnServiceFailedListener() {
                @Override
                public void onError(BaseError baseError) {
                    getPresenter().onError(baseError);
                }
            };
            mLoginService = new LoginService(onServiceSuccessListener, onServiceFailedListener);
        }
        mLoginService.startLoginService(username, password);
    }

    public void getSettings() {
        OnServiceSuccessListener onServiceSuccessListener = new OnServiceSuccessListener() {
            @Override
            public void onSuccess() {
                getPresenter().onSettingsRetrieved();
            }
        };

        OnServiceFailedListener onServiceFailedListener = new OnServiceFailedListener() {
            @Override
            public void onError(BaseError baseError) {
                getPresenter().onError(baseError);
            }
        };
        new GetSettingsService(onServiceSuccessListener, onServiceFailedListener).getSettingsService();
    }
}
