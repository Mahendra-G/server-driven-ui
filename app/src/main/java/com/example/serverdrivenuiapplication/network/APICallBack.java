package com.example.serverdrivenuiapplication.network;

public interface APICallBack<T> {

    void onSuccess(T response);

    void onFailure();
}

