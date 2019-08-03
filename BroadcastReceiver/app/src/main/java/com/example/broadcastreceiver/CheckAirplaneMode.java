package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;

public class CheckAirplaneMode extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        boolean isAction = isAvtive(context);
    }

    private boolean isAvtive(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.ACTION_AIRPLANE_MODE_SETTINGS, -1) != 0;
    }
}
