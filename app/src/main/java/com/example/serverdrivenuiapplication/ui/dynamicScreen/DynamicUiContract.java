package com.example.serverdrivenuiapplication.ui.dynamicScreen;

import com.example.serverdrivenuiapplication.base.BasePresenter;
import com.example.serverdrivenuiapplication.base.BaseView;
import com.example.serverdrivenuiapplication.model.DataResponse;

public interface DynamicUiContract {

    interface View extends BaseView<DynamicUiContract.Presenter> {

        void onDisplayScreenSuccess(DataResponse dataResponse);

        void onDisplayScreenFailure(String message);
    }

    interface Presenter extends BasePresenter {

       // void displayScreen(DataResponse dataResponse, int selectedId);
        void displayScreen(int selectedId);

    }
}
