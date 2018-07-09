package com.vodafone.mvpdesignpattern.bases;

import android.content.Context;

/**
 * Created by Mohammad Sayed on 2/19/2018.
 */

public abstract class BasePresenter<V extends BaseContract.IBaseView, R extends BaseContract.IBaseRepository> {

    private V mView;
    private R mRepository;
    private Context mContext;

    public BasePresenter(Context context, V view) {
        this.mContext = context;
        this.mView = view;
        this.mRepository = createRepository();
    }

    protected abstract R createRepository();

    public Context getContext() {
        return mContext;
    }

    public V getView() {
        return mView;
    }


    public R getRepository() {
        return mRepository;
    }

    public void setContext(Context context) {
        mContext = context;
    }
}
