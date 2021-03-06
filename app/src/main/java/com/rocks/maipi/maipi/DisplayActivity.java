package com.rocks.maipi.maipi;

import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;


public class DisplayActivity extends ActionBarActivity {

    PiData mData;
    String mPiName;
    String mPiURL;
    DisplayActivityGUI mGUI;
    DisplayActivityListener mListener;
    Bundle mPiInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);
        mPiInfo= this.getIntent().getExtras();
        mPiName = mPiInfo.getString("piName", "Intent fehlgeschlagen");
        mPiURL = mPiInfo.getString("piURL", "Intent fehlgeschlagen");
        initData();
        initGUI();
        initListener();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_display, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        if (id == R.id.refreshPiData) {
            this.mGUI.updateGUI();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String getPiName() {
        return mPiName;
    }

    public String getPiURL() {
        return mPiURL;
    }

    public void initData(){
        mData = new PiData(this);
    }

    public void initGUI(){
        mGUI = new DisplayActivityGUI(this, mPiInfo);
    }

    public void initListener(){
        mListener = new DisplayActivityListener(this,mGUI);
    }
}
