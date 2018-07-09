package com.vodafone.mvpdesignpattern.bases;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ProgressBar;

/**
 * Created by Mohammad Sayed on 2/19/2018.
 */

public abstract class BaseActivity<P extends BaseContract.IBasePresenter> extends AppCompatActivity {

    public P mPresenter;

    private ProgressBar mPbLoading;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();
    }

    public P getPresenter() {
        return mPresenter;
    }

    abstract protected P createPresenter();

    public void setLoadingProgressBar(ProgressBar progressBar) {
        mPbLoading = progressBar;
    }

    public void showProgressLoading(boolean show) {
        if (mPbLoading != null) {
            mPbLoading.setVisibility(show ? View.VISIBLE : View.GONE);
        }
    }
}
