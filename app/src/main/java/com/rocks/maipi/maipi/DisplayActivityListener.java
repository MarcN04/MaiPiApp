package com.rocks.maipi.maipi;

import android.view.View;

/**
 * Created by Marc on 03.05.2015.
 */
public class DisplayActivityListener implements View.OnClickListener{

    DisplayActivity mActivity;
    DisplayActivityGUI mGUI;

    DisplayActivityListener(DisplayActivity activity, DisplayActivityGUI gui){
        mActivity = activity;
        mGUI = gui;
        mGUI.getBtnRestart().setOnClickListener(this);
        mGUI.getBtnShutdown().setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.btnRestart:
                JSONControlTask restart = new JSONControlTask(mActivity, mGUI, mActivity.getPiURL(), "/reboot");
                restart.execute();
                break;
            case R.id.btnShutDown:
                JSONControlTask shutdown = new JSONControlTask(mActivity, mGUI, mActivity.getPiURL(), "/shutdown");
                shutdown.execute();
                break;
        }
    }
}
