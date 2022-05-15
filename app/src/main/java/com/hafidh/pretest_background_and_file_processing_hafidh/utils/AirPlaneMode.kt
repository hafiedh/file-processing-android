package com.hafidh.pretest_background_and_file_processing_hafidh.utils

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirPlaneMode: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
       val state = intent?.getBooleanExtra("state",false)
        if (state == true){
            Toast.makeText(context,"Airplane mode on",Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(context,"Airplane mode off",Toast.LENGTH_SHORT).show()
        }
    }
}