package com.rocks.maipi.maipi;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Marc on 04.05.2015.
 */
public class JSONStateTask extends AsyncTask <Void, Void, JSONArray> {

    private DisplayActivity mActivity;
    private DisplayActivityGUI mGUI;
    private String mURL;

    public JSONStateTask(DisplayActivity activity, DisplayActivityGUI gui, String url){
        mActivity = activity;
        mGUI = gui;
        mURL = url;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        // Showing progress dialog
        mGUI.getDisplayTempText().setText("Data is loading!");
        mGUI.getDisplayCPUFrequencyText().setText("Data is loading!");
        mGUI.getDisplayCPUVoltageText().setText("Data is loading!");
        mGUI.getDisplayMemoryText().setText("Data is loading!");
    }

    @Override
    protected JSONArray doInBackground(Void... params) {
        JSONStateParser jParser = new JSONStateParser();
        JSONArray json = jParser.getJSONFromUrl(mURL + "/status");
        if(json == null) {
            JSONArray error = new JSONArray();
            JSONObject warning = new JSONObject();
            try {
                warning.put("error", "noconnection");
            } catch (JSONException e) {
                e.printStackTrace();
            }
            error.put(warning);
            json = error;
        }
        return json;
    }

    @Override
    protected void onPostExecute(JSONArray result) {
        super.onPostExecute(result);
        // Dismiss the progress dialog
        try {
            if(result.length() > 1){
                mGUI.getDisplayTempText().setText(result.getJSONObject(0).getString("value") + "°C");
                mGUI.getDisplayCPUFrequencyText().setText(result.getJSONObject(1).getString("value") + "MHz");
                mGUI.getDisplayCPUVoltageText().setText(result.getJSONObject(2).getString("value") + "V");
                mGUI.getDisplayMemoryText().setText(result.getJSONObject(3).getString("value") + "%");
            } else {
                mGUI.getDisplayTempText().setText("No connection!");
                mGUI.getDisplayCPUFrequencyText().setText("No connection!");
                mGUI.getDisplayCPUVoltageText().setText("No connection!");
                mGUI.getDisplayMemoryText().setText("No connection!");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
