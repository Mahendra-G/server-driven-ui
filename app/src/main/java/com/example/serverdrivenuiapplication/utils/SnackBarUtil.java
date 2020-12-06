package com.example.serverdrivenuiapplication.utils;

import android.view.Gravity;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.example.serverdrivenuiapplication.R;
import com.google.android.material.snackbar.Snackbar;
import androidx.core.content.ContextCompat;


public class SnackBarUtil {

    public static void setSnackBar(RelativeLayout rootLayout, String message) {
        Snackbar snackbar = Snackbar
                .make(rootLayout, message, Snackbar.LENGTH_LONG);

        snackbar.show();
    }

}
