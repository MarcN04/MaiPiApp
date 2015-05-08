package com.rocks.maipi.maipi;

import android.content.SharedPreferences;

import java.util.ArrayList;

/**
 * Created by Marc on 07.05.2015.
 */
public class PiData {
    public static final String Pref_NAME = "MYDATA";
    SharedPreferences mData;
    DisplayActivity mActivity;
    StartActivity mStartActivity;
    int mSize;

    public PiData(DisplayActivity activity){
        mActivity = activity;
        mData = activity.getSharedPreferences(Pref_NAME,0);
        updateSize();
    }

    public PiData(StartActivity activity){
        mStartActivity = activity;
        mData = activity.getSharedPreferences(Pref_NAME,0);
        updateSize();
    }

    public int getSize() {
        return mSize;
    }

    public void updateSize(){
        int counter = 0;
        while (mData.getString("piName" + counter, "empty") != "empty"){
            counter++;
        }
        SharedPreferences.Editor editor = mData.edit();
        editor.putInt("size", counter);
        editor.commit();
        mSize = counter;
    }

    public ArrayList<MaiPi> getPiList(){
        int size = mData.getInt("size", 0);
        ArrayList<MaiPi> piList = new ArrayList<MaiPi>();
        for ( int i = 0; i < size; i++){
            MaiPi currPi = new MaiPi();
            currPi.setName(mData.getString("piName" + i, "verzählt"));
            currPi.setURL(mData.getString("piURL" + i, "verzählt"));
            piList.add(currPi);
        }
        return piList;
    }

    public void addNewPi(String name, String url){
        int size = mData.getInt("size", 0);
        if(size != 0){

        }
        SharedPreferences.Editor editor = mData.edit();
        editor.putString("piName" + size, name);
        editor.putString("piURL" + size, url);
        editor.commit();
        updateSize();
    }
}
