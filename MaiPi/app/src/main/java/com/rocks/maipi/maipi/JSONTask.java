package com.rocks.maipi.maipi;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.SimpleAdapter;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Marc on 04.05.2015.
 */
public class JSONTask extends AsyncTask <Void, Void, JSONObject> {

    private DisplayActivity mActivity;
    private DisplayActivityGUI mGUI;
    private String mURL;

    public JSONTask (DisplayActivity activity, DisplayActivityGUI gui, String url){
        mActivity = activity;
        mGUI = gui;
        mURL = url;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Showing progress dialog
        mGUI.getJSONText().setText("JSON wird geladen!");
    }

    @Override
    protected JSONObject doInBackground(Void... params) {
        String url = "http://192.168.2.121:3000/temp";

        JSONParser jParser = new JSONParser();
        JSONObject json = jParser.getJSONFromUrl(url);

        return json;
    }

    @Override
    protected void onPostExecute(JSONObject result) {
        super.onPostExecute(result);
        // Dismiss the progress dialog
        try {
            mGUI.getJSONText().setText(result.getString("name") + result.getString("temp"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
