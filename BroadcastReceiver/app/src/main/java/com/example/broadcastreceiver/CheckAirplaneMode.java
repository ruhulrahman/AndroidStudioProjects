package com.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Settings;
import android.widget.Toast;

public class CheckAirplaneMode extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        if(intent.getAction() == Intent.ACTION_AIRPLANE_MODE_CHANGED){
            boolean isAction = isAvtive(context);
            if(isAction){
                Toast.makeText(context, "Airplane Mode On", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(context, "Airplane Mode Off", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private boolean isAvtive(Context context) {
        return Settings.System.getInt(context.getContentResolver(), Settings.System.AIRPLANE_MODE_ON, -1) != 0;
    }
}
