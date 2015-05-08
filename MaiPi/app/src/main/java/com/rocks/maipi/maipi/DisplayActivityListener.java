package com.rocks.maipi.maipi;

import android.content.DialogInterface;
import android.view.View;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Marc on 03.05.2015.
 */
public class DisplayActivityListener implements View.OnClickListener{

    DisplayActivity mActivity;
    DisplayActivityGUI mGUI;

    DisplayActivityListener(DisplayActivity activity, DisplayActivityGUI gui){
        mActivity = activity;
        mGUI = gui;
        gui.getJSONButton().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        JSONTask loader  = new JSONTask(mActivity, mGUI);
        loader.execute();
    }
}
