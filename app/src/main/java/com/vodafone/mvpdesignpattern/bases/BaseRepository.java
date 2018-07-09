package com.vodafone.mvpdesignpattern.bases;

import com.vodafone.mvpdesignpattern.login.LoginPresenter;

/**
 * Created by Mohammad Sayed on 2/19/2018.
 */

public class BaseRepository<P extends BaseContract.IBasePresenter> {

    private P mBasePresenter;

    public BaseRepository(P presenter) {
        this.mBasePresenter = presenter;
    }

    public P getPresenter() {
        return mBasePresenter;
    }
}
