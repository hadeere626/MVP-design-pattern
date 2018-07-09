package com.vodafone.mvpdesignpattern.bases;

/**
 * Created by Mohammad Sayed on 2/18/2018.
 */

public abstract class BaseService {

    private OnServiceSuccessListener mOnServiceSuccessListener;

    public BaseService(OnServiceSuccessListener onServiceSuccessListener) {
        this.mOnServiceSuccessListener = onServiceSuccessListener;
    }


    public OnServiceSuccessListener getOnServiceSuccessListener() {
        return mOnServiceSuccessListener;
    }
}
