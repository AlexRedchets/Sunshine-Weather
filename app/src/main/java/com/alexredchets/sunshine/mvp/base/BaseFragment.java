package com.alexredchets.sunshine.mvp.base;

import android.app.ProgressDialog;
import android.support.v4.app.Fragment;

public abstract class BaseFragment extends Fragment {

    private ProgressDialog mProgressDialog;

    protected void showProgressDialog(String message){
        if (mProgressDialog == null){
            mProgressDialog = new ProgressDialog(getContext());
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    protected void hideProgressDialog(){
        if (mProgressDialog != null && mProgressDialog.isShowing())
            mProgressDialog.dismiss();
    }
}
