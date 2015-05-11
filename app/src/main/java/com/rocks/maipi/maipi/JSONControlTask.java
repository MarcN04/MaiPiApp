package com.rocks.maipi.maipi;

import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Marc on 04.05.2015.
 */
public class JSONControlTask extends AsyncTask <Void, Void, String> {

    private DisplayActivity mActivity;
    private DisplayActivityGUI mGUI;
    private String mURL;
    private String mCommand;

    public JSONControlTask(DisplayActivity activity, DisplayActivityGUI gui, String url, String command){
        mActivity = activity;
        mGUI = gui;
        mURL = url;
        mCommand = command;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... params) {
        JSONControlParser loader = new JSONControlParser();
        String response = loader.getJSONResponseFromUrl(mURL + mCommand);
        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        // Dismiss the progress dialog
        if(result.equals("ok")){
            switch(mCommand){
                case "/shutdown":
                    Toast.makeText(mActivity.getApplicationContext(), "Pi is shut down!",
                            Toast.LENGTH_SHORT).show();
                    break;
                case "/reboot":
                    Toast.makeText(mActivity.getApplicationContext(), "Pi is rebooted!",
                            Toast.LENGTH_SHORT).show();
                    break;
            }
        } else {
            Toast.makeText(mActivity.getApplicationContext(), "No connection, try again!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}
