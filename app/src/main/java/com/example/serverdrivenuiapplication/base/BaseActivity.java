package com.example.serverdrivenuiapplication.base;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.serverdrivenuiapplication.R;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public abstract void initView();

    public abstract void setValues();
}