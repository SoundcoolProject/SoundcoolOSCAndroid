package org.soundcool.upv.oscapp;

import android.os.AsyncTask;

import com.illposed.osc.OSCMessage;

import java.util.ArrayList;
import java.util.List;


public class OSCsender extends AsyncTask {

    private Exception exception;

    @Override
    protected Object doInBackground(Object[] params) {
        List<Object> arg = new ArrayList<Object>(1);
        arg.add((params[1]));
        String dir = (String) params[0];    // por saber... mirar  por qué necesita Casting

        OSCMessage msg = new OSCMessage(dir, arg);


        try {
            MainActivity.MYoscPortOut.send(msg);
            return true;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }

    }

    //protected void onPostExecute(boolean result) {    }
}
