package com.example.checkcallstate;

import android.Manifest;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.provider.Telephony;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import android.widget.Toast;

public class MyReciever extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {


        TelephonyManager tm = (TelephonyManager) context.getSystemService(Service.TELEPHONY_SERVICE);
        int state = tm.getCallState();
        if (checkSelfPermission(Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.READ_PHONE_NUMBERS) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    Activity#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for Activity#requestPermissions for more details.
            return;
        }
        String number = tm.getLine1Number();


        if(state == TelephonyManager.CALL_STATE_OFFHOOK){
            Toast.makeText(context, "CALL RECIEVED :"+number, Toast.LENGTH_SHORT).show();

        }
        if(state == TelephonyManager.CALL_STATE_IDLE){
//            Toast.makeText(context, "You have misscall from :"+number, Toast.LENGTH_SHORT).show();

        }
        if(state == TelephonyManager.CALL_STATE_RINGING){
            Toast.makeText(context, " INCOMING CALL:"+number, Toast.LENGTH_SHORT).show();

        }
        else {
            //Here comes the Pi command.
            Toast.makeText(context, "You have misscall from :"+number, Toast.LENGTH_SHORT).show();
        }


    }

    private int checkSelfPermission(String readSms) {
        return 0;
    }
}
