package com.alexredchets.sunshineweather;

import android.util.Log;

import com.crashlytics.android.Crashlytics;

import timber.log.Timber;

public class ReleaseTree extends Timber.Tree {

    private static final int MAX_LOG_LENGTH = 4000;

    @Override
    protected boolean isLoggable(String tag, int priority) {

        //Only LOG WARN, ERROR, WTF
        return !(priority == Log.VERBOSE || priority == Log.DEBUG || priority == Log.INFO);
    }

    @Override
    protected void log(int priority, String tag, String message, Throwable t) {
        if (isLoggable(tag, priority)){

            //Report caught exception to Crashlytics
            if (priority == Log.ERROR && t != null){
                Crashlytics.log(t.getMessage());
            }

            //Message is short enough, does not need to be broken into chunks
            if (message.length() < MAX_LOG_LENGTH){
                Log.wtf(tag, message);
            }
            else {
                Log.println(priority, tag, message);
            }
            return;
        }

        //Split by line, then ensure each line can fit into Log's max length
        for (int i = 0, length = message.length(); i < length; i++){
            int newline = message.indexOf('\n', i);
            newline = newline != -1 ? newline : length;
            do{
                int end = Math.min(newline, i + MAX_LOG_LENGTH);
                String part = message.substring(i, end);
                if (priority == Log.ASSERT){
                    Log.wtf(tag, part);
                }
                else {
                    Log.println(priority, tag, part);
                }
                i = end;
            } while (i < newline);
        }
    }
}
