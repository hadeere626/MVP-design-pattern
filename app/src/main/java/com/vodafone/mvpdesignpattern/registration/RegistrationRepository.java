package com.vodafone.mvpdesignpattern.registration;

import com.vodafone.mvpdesignpattern.bases.BaseError;
import com.vodafone.mvpdesignpattern.bases.BaseRepository;
import com.vodafone.mvpdesignpattern.bases.OnServiceFailedListener;
import com.vodafone.mvpdesignpattern.bases.OnServiceSuccessListener;
import com.vodafone.mvpdesignpattern.login.GetSettingsService;
import com.vodafone.mvpdesignpattern.login.LoginContract;
import com.vodafone.mvpdesignpattern.login.LoginPresenter;
import com.vodafone.mvpdesignpattern.login.LoginService;

/**
 * Created by Mohammad Sayed on 2/18/2018.
 */

public class RegistrationRepository extends BaseRepository<RegistrationContract.IRegisterPresenter>
        implements RegistrationContract.IRegisterRepository {

    private RegisterService mRegisterService;

    public RegistrationRepository(RegistrationPresenter RegisterPresenter) {
        super(RegisterPresenter);
    }

    public void startRegisterService(String username, String password) {
        if (mRegisterService == null) {
            OnServiceSuccessListener onServiceSuccessListener = new OnServiceSuccessListener() {
                @Override
                public void onSuccess() {
                    getPresenter().onRegisterSucceeded();
                }
            };

            OnServiceFailedListener onServiceFailedListener = new OnServiceFailedListener() {
                @Override
                public void onError(BaseError baseError) {
                    getPresenter().onError(baseError);
                }
            };
            mRegisterService = new RegisterService(onServiceSuccessListener, onServiceFailedListener);
        }
        mRegisterService.startRegisterService(username, password);
    }


}

