package com.example.serverdrivenuiapplication.ui.dummyOptions;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.CellSignalStrength;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.serverdrivenuiapplication.R;
import com.example.serverdrivenuiapplication.base.BaseActivity;
import com.example.serverdrivenuiapplication.base.BaseView;
import com.example.serverdrivenuiapplication.ui.dynamicScreen.DynamicUiActivity;
import com.example.serverdrivenuiapplication.ui.dynamicScreen.DynamicUiContract;
import com.example.serverdrivenuiapplication.utils.NetworkAvailableUtil;
import com.example.serverdrivenuiapplication.utils.SnackBarUtil;

public class DummyOptionsActivity extends BaseActivity implements BaseView {

    private RelativeLayout mDummyOptionLayout;

    private Spinner mOptionSpinner;
    private String[] mDummyOptionArray = {"Select Option","Option 1","Option 2","Option 3"};
    private String mSelectedOption;
    private int mSelectedId;
    private Button mProceedButton;
    private ProgressBar mProgressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy_options);
        initView();
        setValues();
    }

    @Override
    public void initView() {
        mDummyOptionLayout = findViewById(R.id.rl_dummy);
        mOptionSpinner = findViewById(R.id.sp_options);
        mProceedButton = findViewById(R.id.btn_proceed);
        mProgressBar = findViewById(R.id.pb_options);

        ArrayAdapter optionAdapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item, mDummyOptionArray);
        optionAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mOptionSpinner.setAdapter(optionAdapter);
    }

    @Override
    public void setValues() {
        mOptionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                mSelectedOption = mDummyOptionArray[i];
                switch (mSelectedOption) {
                    case "Option 1":
                        mSelectedId = 1;
                        break;
                    case "Option 2":
                        mSelectedId = 2;
                        break;
                    case "Option 3":
                        mSelectedId = 3;
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mProceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (NetworkAvailableUtil.isNetworkAvailable(DummyOptionsActivity.this)) {
                    if (mSelectedOption.equals("Select Option")) {
                        Toast.makeText(DummyOptionsActivity.this, "Please select option", Toast.LENGTH_SHORT).show();
                    } else {
                        Intent i = new Intent(DummyOptionsActivity.this, DynamicUiActivity.class);
                        i.putExtra("optionId", mSelectedId);
                        startActivity(i);
                    }

                }
                else
                    SnackBarUtil.setSnackBar(mDummyOptionLayout,"Internet not available");
            }
        });
    }

    @Override
    public void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showSnackBar(String message) {
        SnackBarUtil.setSnackBar(mDummyOptionLayout, message);
    }

    @Override
    public void setPresenter(Object presenter) {

    }
}