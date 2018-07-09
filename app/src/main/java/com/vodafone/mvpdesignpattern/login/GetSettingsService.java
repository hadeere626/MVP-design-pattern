package com.vodafone.mvpdesignpattern.login;

import android.os.Handler;

import com.vodafone.mvpdesignpattern.bases.BaseError;
import com.vodafone.mvpdesignpattern.bases.BaseService;
import com.vodafone.mvpdesignpattern.bases.OnServiceFailedListener;
import com.vodafone.mvpdesignpattern.bases.OnServiceSuccessListener;

/**
 * Created by Mohammad Sayed on 2/18/2018.
 */

public class GetSettingsService extends BaseService {

    boolean mGetSettingsSucceeded = true;
    private OnServiceFailedListener mOnServiceFailedListener;

    public GetSettingsService(OnServiceSuccessListener onServiceSuccessListener, OnServiceFailedListener onServiceFailedListener) {
        super(onServiceSuccessListener);
        mOnServiceFailedListener = onServiceFailedListener;

    }

    public void getSettingsService() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mGetSettingsSucceeded) {
                    if (getOnServiceSuccessListener() != null) {
                        getOnServiceSuccessListener().onSuccess();
                    }
                } else {
                    if (mOnServiceFailedListener != null) {
                        BaseError baseError = new BaseError();
                        baseError.setMessage("Get Settings Failed");
                        mOnServiceFailedListener.onError(baseError);
                    }
                }
                mGetSettingsSucceeded = !mGetSettingsSucceeded;
            }
        }, 1000);
    }
}
