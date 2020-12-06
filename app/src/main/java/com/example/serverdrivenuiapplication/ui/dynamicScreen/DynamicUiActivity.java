package com.example.serverdrivenuiapplication.ui.dynamicScreen;

import android.annotation.SuppressLint;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;

import com.example.serverdrivenuiapplication.R;
import com.example.serverdrivenuiapplication.base.BaseActivity;
import com.example.serverdrivenuiapplication.model.DataResponse;
import com.example.serverdrivenuiapplication.model.ResultResponse;
import com.example.serverdrivenuiapplication.model.Type;
import com.example.serverdrivenuiapplication.model.UIFields;
import com.example.serverdrivenuiapplication.model.UIType;
import com.example.serverdrivenuiapplication.model.Values;
import com.example.serverdrivenuiapplication.utils.SnackBarUtil;

import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static android.graphics.Typeface.BOLD;

public class DynamicUiActivity extends BaseActivity implements DynamicUiContract.View {

    private RelativeLayout mContainerRelativeLayout;
    private int mSpinnerSelectedId;
    private ProgressBar mProgressBar;
    private String mSelectedSpinner = "";
    private DynamicUiPresenter mDynamicUiPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_ui);

        initView();
        setValues();
    }

    @Override
    public void initView() {
        mContainerRelativeLayout = findViewById(R.id.container);
        int mSelectedId = Objects.requireNonNull(getIntent().getExtras()).getInt("optionId");
        mProgressBar = findViewById(R.id.pb_dynamicScreen);
        new DynamicUiPresenter(this, this, new DynamicUiRepository());
        getDetails(mSelectedId);
    }

    @Override
    public void setValues() {

    }

    private void getDetails(int selectedId) {
        mDynamicUiPresenter.displayScreen(selectedId);
    }

    private void setHeaderUI(ResultResponse resultResponse) {
        List<UIFields> uiFieldsList;
        String screenTitle = resultResponse.getScreen_title();
        uiFieldsList = resultResponse.getUiFields();

        //create screen title
        TextView headerTextView = new TextView(this);
        headerTextView.setText(screenTitle);
        RelativeLayout.LayoutParams headerParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        headerTextView.setLayoutParams(headerParams);
        headerTextView.setId(View.generateViewId());
        headerTextView.setGravity(Gravity.CENTER_HORIZONTAL);
        headerTextView.setTextSize(24);
        headerParams.setMargins(0, 40, 0, 0);
        headerTextView.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        mContainerRelativeLayout.addView(headerTextView);
        setUiFields(uiFieldsList);
    }

    private void setUiFields(final List<UIFields> uiFieldsList) {

        for (int i = 0; i < uiFieldsList.size(); i++) {
            UIType UITypeList = uiFieldsList.get(i).getUITypeList();
            List<Values> valuesList = UITypeList.getValuesList();
            Type data_type = uiFieldsList.get(i).getType();
            String type = UITypeList.getType();
            if (type.equals("textfield")) {

                TextView mLabelTextView = new TextView(this);
                RelativeLayout.LayoutParams mLabelParams = new RelativeLayout.
                        LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                        RelativeLayout.LayoutParams.WRAP_CONTENT);
                mLabelTextView.setLayoutParams(mLabelParams);
                mLabelTextView.setTextSize(16);
                mLabelTextView.setTextColor(Color.BLACK);
                mLabelTextView.setTypeface(mLabelTextView.getTypeface(), BOLD);
                mLabelParams.setMargins(12, 40, 12, 0);
                mLabelTextView.setHint(uiFieldsList.get(i).getPlaceholder());
                //generating id and assigning it to field
                mLabelTextView.setId(View.generateViewId());
                // aligning the field below to its child item
                for (int j = 0; j < mContainerRelativeLayout.getChildCount(); j++) {
                    View child = mContainerRelativeLayout.getChildAt(j);
                    mLabelParams.addRule(RelativeLayout.BELOW, child.getId());
                }
                mContainerRelativeLayout.addView(mLabelTextView);

                EditText userInputEditText = new EditText(this);
                RelativeLayout.LayoutParams userInputParams = new RelativeLayout.LayoutParams
                        (RelativeLayout.LayoutParams.MATCH_PARENT,
                                RelativeLayout.LayoutParams.WRAP_CONTENT);
                userInputEditText.setLayoutParams(userInputParams);
                userInputParams.setMargins(12, 0, 12, 0);
                userInputEditText.setHint(uiFieldsList.get(i).getHint_text());
                if (data_type.getData_type().equals("int")) {
                    userInputEditText.setInputType(InputType.TYPE_CLASS_NUMBER);
                } else if (data_type.getData_type().equals("string")) {
                    userInputEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                // change the editText line color
                @SuppressLint("ResourceAsColor") ColorStateList colorStateList = ColorStateList.valueOf(R.color.colorPrimary);
                userInputEditText.setBackgroundTintList(colorStateList);
                //generating id and assigning it to field
                userInputEditText.setId(View.generateViewId());
                for (int j = 0; j < mContainerRelativeLayout.getChildCount(); j++) {
                    View child = mContainerRelativeLayout.getChildAt(j);
                    userInputParams.addRule(RelativeLayout.BELOW, child.getId());
                }
                mContainerRelativeLayout.addView(userInputEditText);

            } else if (type.equals("dropdown")) {
                TextView monthLabelTextView = new TextView(this);
                RelativeLayout.LayoutParams monthLabelParams = new RelativeLayout.LayoutParams
                        (RelativeLayout.LayoutParams.MATCH_PARENT,
                                RelativeLayout.LayoutParams.WRAP_CONTENT);
                monthLabelTextView.setLayoutParams(monthLabelParams);
                monthLabelTextView.setTextSize(16);
                monthLabelTextView.setTextColor(Color.BLACK);
                monthLabelTextView.setTypeface(monthLabelTextView.getTypeface(), BOLD);
                monthLabelParams.setMargins(12, 24, 12, 0);
                monthLabelTextView.setHint(uiFieldsList.get(i).getPlaceholder());
                //generating id and assigning it to field
                monthLabelTextView.setId(View.generateViewId());
                // aligning the field below to its child item
                for (int j = 0; j < mContainerRelativeLayout.getChildCount(); j++) {
                    View child = mContainerRelativeLayout.getChildAt(j);
                    monthLabelParams.addRule(RelativeLayout.BELOW, child.getId());
                }

                mContainerRelativeLayout.addView(monthLabelTextView);
                if (!valuesList.isEmpty()) {
                    Spinner spinner = new Spinner(this);
                    RelativeLayout.LayoutParams monthSpinnerParams = new
                            RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                            RelativeLayout.LayoutParams.WRAP_CONTENT);
                    monthSpinnerParams.setMargins(12, 0, 12, 0);
                    spinner.setLayoutParams(monthSpinnerParams);
                    spinner.setId(View.generateViewId());
                    spinner.setPrompt(uiFieldsList.get(i).getHint_text());
                    //setting the hint text to list
                    valuesList.add(0, new Values(uiFieldsList.get(i).getHint_text(), 0));
                    // adding list to adapter
                    ArrayAdapter<Values> spinnerArrayAdapter = new ArrayAdapter<>(this,
                            android.R.layout.simple_spinner_dropdown_item, valuesList);
                    spinner.setAdapter(spinnerArrayAdapter);
                    // aligning the field below to its child item
                    for (int j = 0; j < mContainerRelativeLayout.getChildCount(); j++) {
                        View child = mContainerRelativeLayout.getChildAt(j);
                        monthSpinnerParams.addRule(RelativeLayout.BELOW, child.getId());
                    }
                    // adding spinner to layout
                    mContainerRelativeLayout.addView(spinner);

                    spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            Values obj = (Values) adapterView.getItemAtPosition(i);
                            mSpinnerSelectedId = obj.getId();
                            mSelectedSpinner = obj.getName();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {

                        }
                    });
                }
            }
        }
        setProceedButton(uiFieldsList);
    }

    private void setProceedButton(final List<UIFields> uiFieldList) {
        Button mProceedButton = new Button(this);
        RelativeLayout.LayoutParams proceedButtonParams = new
                RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT);
        proceedButtonParams.setMargins(120, 120, 120, 0);
        mProceedButton.setLayoutParams(proceedButtonParams);
        mProceedButton.setText(R.string.btn_proceed);
        mProceedButton.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.white));
        mProceedButton.setBackgroundResource(R.drawable.bg_button);
        mProceedButton.setId(View.generateViewId());
        for (int j = 0; j < mContainerRelativeLayout.getChildCount(); j++) {
            View child = mContainerRelativeLayout.getChildAt(j);
            proceedButtonParams.addRule(RelativeLayout.BELOW, child.getId());
        }

        mContainerRelativeLayout.addView(mProceedButton);

        mProceedButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isValidEdiText = validateEditTextFields(uiFieldList);
                boolean isValidSpinner = validateSpinner(uiFieldList);

                if (!isValidEdiText && mSpinnerSelectedId == 0) {
                    Toast.makeText(DynamicUiActivity.this, "Fields can't be empty", Toast.LENGTH_SHORT).show();
                } else if (!isValidSpinner && !mSelectedSpinner.isEmpty()) {
                    Toast.makeText(DynamicUiActivity.this, "select option", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(DynamicUiActivity.this, "Saved", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private boolean validateSpinner(List<UIFields> uiFieldList) {
        boolean isValid = false;
        for (int i = 0; i < uiFieldList.size(); i++) {
            for (int j = 0; j < mContainerRelativeLayout.getChildCount(); j++) {
                View view1 = mContainerRelativeLayout.getChildAt(j);
                if (view1.getClass().getName().equals("android.widget.Spinner")) {
                    if (uiFieldList.get(i).isIs_mandatory()) {
                        isValid = mSpinnerSelectedId != 0;
                    } else {
                        isValid = true;
                    }
                }
            }
            break;
        }
        return isValid;
    }

    private boolean validateEditTextFields(List<UIFields> uiFieldList) {
        boolean isValid = false;
        for (int i = 0; i < uiFieldList.size(); i++) {
            for (int j = 0; j < mContainerRelativeLayout.getChildCount(); j++) {
                View view1 = mContainerRelativeLayout.getChildAt(j);
                if (view1.getClass().getName().equals("android.widget.EditText")) {
                    EditText text = view1.findViewById(view1.getId());
                    if (uiFieldList.get(i).isIs_mandatory()) {
                        isValid = text.getText().toString().trim().length() != 0;
                    } else {
                        isValid = true;
                    }
                }
            }
            break;
        }
        return isValid;
    }

    @Override
    public void onDisplayScreenSuccess(DataResponse dataResponse) {
        ResultResponse resultResponse = dataResponse.getResponses();
        setHeaderUI(resultResponse);
    }

    @Override
    public void onDisplayScreenFailure(String message) {
        Toast.makeText(this, "Fail", Toast.LENGTH_SHORT).show();
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
        SnackBarUtil.setSnackBar(mContainerRelativeLayout, message);
    }

    @Override
    public void setPresenter(DynamicUiContract.Presenter presenter) {
        mDynamicUiPresenter = (DynamicUiPresenter) presenter;
    }
}