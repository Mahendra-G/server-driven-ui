package com.example.serverdrivenuiapplication.ui.dynamicScreen;

import android.content.Context;

import com.example.serverdrivenuiapplication.model.DataResponse;
import com.example.serverdrivenuiapplication.network.APICallBack;
import com.example.serverdrivenuiapplication.utils.NetworkAvailableUtil;

public class DynamicUiPresenter implements DynamicUiContract.Presenter {

    private DynamicUiContract.View mView;
    private Context mContext;
    private DynamicUiRepository mDynamicUiRepository;

    public DynamicUiPresenter(DynamicUiContract.View mView, Context mContext, DynamicUiRepository mDynamicUiRepository) {
        this.mView = mView;
        this.mContext = mContext;
        this.mDynamicUiRepository= mDynamicUiRepository;
        mView.setPresenter(this);
    }

    @Override
    public void displayScreen( int selectedId) {
        if (NetworkAvailableUtil.isNetworkAvailable(mContext)) {
            mView.showProgressBar();
            mDynamicUiRepository.displayScreen(selectedId, new APICallBack<DataResponse>() {
                @Override
                public void onSuccess(DataResponse response) {

                    mView.hideProgressBar();
                    mView.onDisplayScreenSuccess(response);
                }
                @Override
                public void onFailure() {
                    mView.hideProgressBar();
                    mView.onDisplayScreenFailure("Some thing went wrong!");
                }
            });
        } else {
            mView.showSnackBar("Internet Not Available !");
        }
    }

    @Override
    public void start() {
        mView.showProgressBar();
    }
}
