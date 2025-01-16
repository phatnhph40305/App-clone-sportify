package com.example.appclonesprotify.services

import android.app.Service
import android.content.Intent
import android.os.IBinder

class PlayMusicService : Service() {


    override fun onCreate() {
        super.onCreate()

    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        return super.onStartCommand(intent, flags, startId)
    }


    override fun onBind(intent: Intent): IBinder? {
        return null;
    }

    override fun onDestroy() {
        super.onDestroy()


    }
}