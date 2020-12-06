package com.example.serverdrivenuiapplication.base;

public interface BaseView<T> {
    void showProgressBar();

    void hideProgressBar();

    void showSnackBar(String message);

    void setPresenter(T presenter);
}
