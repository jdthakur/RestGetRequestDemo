package com.example.linux.restgetrequestdemo.utility;

import android.app.ProgressDialog;
import android.content.Context;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Felix_ITS on 20-12-2016.
 */

public class ProjectUtility {


    public static void showToast(Context context, String msg) {
        Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
    }


    public static void clearFields(EditText... editTexts) {
        for (EditText editText : editTexts) {
            editText.setText("");
        }
    }

    public static ProgressDialog progressDialogForAll(Context con) {

        ProgressDialog mProgressDialog = new ProgressDialog(con);
        mProgressDialog.setMessage("Loading...");
        mProgressDialog.setCancelable(false);
        return mProgressDialog;
    }
}
