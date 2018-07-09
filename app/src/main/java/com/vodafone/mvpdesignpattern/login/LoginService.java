package com.vodafone.mvpdesignpattern.login;

import android.os.Handler;

import com.vodafone.mvpdesignpattern.bases.BaseError;
import com.vodafone.mvpdesignpattern.bases.BaseService;
import com.vodafone.mvpdesignpattern.bases.OnServiceFailedListener;
import com.vodafone.mvpdesignpattern.bases.OnServiceSuccessListener;

/**
 * Created by Mohammad Sayed on 2/18/2018.
 */

public class LoginService extends BaseService {

    private boolean mLoginSucceeded = true;
    private OnServiceSuccessListener mOnServiceSuccessListener;
    private OnServiceFailedListener mOnServiceFailedListener;

    public LoginService(OnServiceSuccessListener onServiceSuccessListener,
                        OnServiceFailedListener onServiceFailedListener) {
        super(onServiceSuccessListener);
        this.mOnServiceSuccessListener = onServiceSuccessListener;
        this.mOnServiceFailedListener = onServiceFailedListener;
    }

    public void startLoginService(String userName, String password) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mLoginSucceeded) {
                    if (mOnServiceSuccessListener != null) {
                        mOnServiceSuccessListener.onSuccess();
                    }
                } else {
                    if (mOnServiceFailedListener != null) {
                        BaseError baseError = new BaseError();
                        baseError.setMessage("Login Failed");
                        mOnServiceFailedListener.onError(baseError);
                    }
                }
                mLoginSucceeded = !mLoginSucceeded;
            }
        }, 1000);
    }
}
