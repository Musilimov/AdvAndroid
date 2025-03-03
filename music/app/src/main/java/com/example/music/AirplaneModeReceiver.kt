package com.example.app.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeReceiver(private val onStatusChanged: (Boolean) -> Unit) : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action == Intent.ACTION_AIRPLANE_MODE_CHANGED) {
            val isEnabled = intent.getBooleanExtra("state", false)
            onStatusChanged(isEnabled)
            Toast.makeText(
                context,
                if (isEnabled) "Режим в самолёте ВКЛЮЧЕН" else "Режим в самолёте ВЫКЛЮЧЕН",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
