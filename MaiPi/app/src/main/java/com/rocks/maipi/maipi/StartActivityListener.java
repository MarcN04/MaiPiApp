package com.rocks.maipi.maipi;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

/**
 * Created by Marc on 03.05.2015.
 */
public class StartActivityListener implements View.OnClickListener, AdapterView.OnItemClickListener{

    StartActivity mActivity;
    PiData mData;
    StartActivityGUI mGUI;

    StartActivityListener(StartActivity activity, StartActivityGUI gui, PiData data){
        mActivity = activity;
        mData = data;
        mGUI = gui;
        mGUI.getBtnAddPi().setOnClickListener(this);
        mGUI.getmPiList().setOnItemClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(mGUI.getWebserviceURLText().getText().toString() != null && mGUI.getPiNameText().getText().toString() != null){
            mData.addNewPi(mGUI.getPiNameText().getText().toString(), mGUI.getWebserviceURLText().getText().toString());
            mGUI.setPiList();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(mActivity.getApplicationContext(), DisplayActivity.class);
        intent.putExtra("piName", mData.getPiList().get(position).getName());
        intent.putExtra("piURL", mData.getPiList().get(position).getURL());
        mActivity.startActivity(intent);
    }
}
