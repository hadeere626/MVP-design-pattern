package com.vodafone.mvpdesignpattern.registration;

import android.os.Handler;

import com.vodafone.mvpdesignpattern.bases.BaseError;
import com.vodafone.mvpdesignpattern.bases.BaseService;
import com.vodafone.mvpdesignpattern.bases.OnServiceFailedListener;
import com.vodafone.mvpdesignpattern.bases.OnServiceSuccessListener;

/**
 * Created by Mohammad Sayed on 2/18/2018.
 */

public class RegisterService extends BaseService {

    private boolean mRegistrationSucceeded = true;
    private OnServiceSuccessListener mOnServiceSuccessListener;
    private OnServiceFailedListener mOnServiceFailedListener;

    public RegisterService(OnServiceSuccessListener onServiceSuccessListener,
                           OnServiceFailedListener onServiceFailedListener) {
        super(onServiceSuccessListener);
        this.mOnServiceSuccessListener = onServiceSuccessListener;
        this.mOnServiceFailedListener = onServiceFailedListener;
    }

    public void startRegisterService(String userName, String password) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mRegistrationSucceeded) {
                    if (mOnServiceSuccessListener != null) {
                        mOnServiceSuccessListener.onSuccess();
                    }
                } else {
                    if (mOnServiceFailedListener != null) {
                        BaseError baseError = new BaseError();
                        baseError.setMessage("Registration Failed");
                        mOnServiceFailedListener.onError(baseError);
                    }
                }
                mRegistrationSucceeded = !mRegistrationSucceeded;
            }
        }, 1000);
    }
}
