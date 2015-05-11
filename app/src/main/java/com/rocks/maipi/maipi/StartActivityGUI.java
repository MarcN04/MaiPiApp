package com.rocks.maipi.maipi;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

/**
 * Created by Marc on 03.05.2015.
 */
public class StartActivityGUI {

    StartActivity mActivity;
    PiData mData;
    Button mBtnAddPi;
    ListView mPiList;
    EditText mWebserviceURLText;
    EditText mPiNameText;

    public StartActivityGUI(StartActivity activity, PiData data){
        mActivity = activity;
        mData = data;
        mBtnAddPi = (Button) mActivity.findViewById(R.id.btnAddPi);
        mPiList = (ListView) mActivity.findViewById(R.id.myPiListView);
        mWebserviceURLText = (EditText) mActivity.findViewById(R.id.newPiUrl);
        mPiNameText = (EditText) mActivity.findViewById(R.id.newPiName);
        setPiList();
    }

    public void setPiList(){
        String[] piList = new String[mData.getSize()];

        for(int i=0; i<mData.getSize(); i++){
            piList[i] = mData.getPiList().get(i).getName();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mActivity,android.R.layout.simple_list_item_1,piList);
        adapter.notifyDataSetChanged();
        mPiList.setAdapter(adapter);
    }

    public Button getBtnAddPi() {
        return mBtnAddPi;
    }

    public ListView getmPiList() {
        return mPiList;
    }

    public EditText getWebserviceURLText() {
        return mWebserviceURLText;
    }

    public EditText getPiNameText() {
        return mPiNameText;
    }
}
