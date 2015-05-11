package com.rocks.maipi.maipi;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;

/**
 * Created by Marc on 03.05.2015.
 */
public class DisplayActivityGUI {

    DisplayActivity mActivity;
    TextView mPiTitle;
    TextView mDisplayTempText;
    TextView mDisplayCPUFrequencyText;
    TextView mDisplayCPUVoltageText;
    TextView mDisplayMemoryText;
    Button mBtnRestart;
    Button mBtnShutdown;

    public DisplayActivityGUI(DisplayActivity activity, Bundle data){
        mActivity = activity;
        mPiTitle = (TextView) mActivity.findViewById(R.id.piTitle);
        mDisplayTempText = (TextView) mActivity.findViewById(R.id.tempView);
        mDisplayCPUFrequencyText = (TextView) mActivity.findViewById(R.id.CPUfrequencyView);
        mDisplayCPUVoltageText = (TextView) mActivity.findViewById(R.id.CPUvoltageView);
        mDisplayMemoryText = (TextView) mActivity.findViewById(R.id.MemoryUsageView);
        mBtnRestart = (Button) mActivity.findViewById(R.id.btnRestart);
        mBtnShutdown = (Button) mActivity.findViewById(R.id.btnShutDown);
        updateGUI();
    }

    public void updateGUI(){
        mPiTitle.setText(mActivity.getPiName());
        JSONStateTask loader  = new JSONStateTask(mActivity, this, mActivity.getPiURL());
        loader.execute();
    }

    public TextView getDisplayTempText() {
        return mDisplayTempText;
    }

    public TextView getDisplayCPUFrequencyText() {
        return mDisplayCPUFrequencyText;
    }

    public TextView getDisplayCPUVoltageText() {
        return mDisplayCPUVoltageText;
    }

    public TextView getDisplayMemoryText() {
        return mDisplayMemoryText;
    }

    public Button getBtnRestart() {
        return mBtnRestart;
    }

    public Button getBtnShutdown() {
        return mBtnShutdown;
    }
}
