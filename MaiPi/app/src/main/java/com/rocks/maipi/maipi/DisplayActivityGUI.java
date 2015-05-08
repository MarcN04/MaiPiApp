package com.rocks.maipi.maipi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

/**
 * Created by Marc on 03.05.2015.
 */
public class DisplayActivityGUI {

    DisplayActivity mActivity;
    Button mJSONButton;
    TextView mJSONText;
    String mPiName;
    String mPiURL;

    public DisplayActivityGUI(DisplayActivity activity, Bundle data){
        mActivity = activity;
        mJSONButton = (Button) mActivity.findViewById(R.id.btnJSON);
        mJSONText = (TextView) mActivity.findViewById(R.id.JSONtext);
        mPiName = data.getString("piName", "Intent fehlgeschlagen");
        mPiURL = data.getString("piURL", "Intent fehlgeschlagen");
        updateGUI();
    }

    public Button getJSONButton() {
        return mJSONButton;
    }

    public TextView getJSONText() {
        return mJSONText;
    }

    public void updateGUI(){
        JSONTask loader  = new JSONTask(mActivity, this, mPiURL);
        loader.execute();
    }
}
