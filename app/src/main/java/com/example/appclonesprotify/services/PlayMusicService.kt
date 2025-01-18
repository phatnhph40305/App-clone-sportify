package com.example.appclonesprotify.services

import android.annotation.SuppressLint
import android.app.Notification
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.example.appclonesprotify.data.model.AlbumTracks
import com.example.appclonesprotify.R
import com.example.appclonesprotify.data.model.Item


class PlayMusicService : Service() {
    private var mediaPlayer: MediaPlayer? = null


    override fun onCreate() {
        super.onCreate()
        Log.d("START_SERVICES", "start thanh cong")


    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
//        val items = Common.tracks?.items
        val position = intent?.getIntExtra("position_song", 0)
        val bundle = intent?.extras
        if (bundle != null && position != null) {
            val tracks: AlbumTracks = bundle.get("list_song") as AlbumTracks
            val trackCurrent = tracks.items[position]
            sendNotification(trackCurrent)
            startMusic(trackCurrent)
        }









        return START_NOT_STICKY
    }

    private fun startMusic(trackCurrent: Item) {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer.create(applicationContext, R.raw.mat_ket_noi_remix)

            //        .apply {
//            setDataSource("https://www.soundhelix.com/examples/mp3/SoundHelix-Song-1.mp3")
//            prepare()
//            start()
//        }
        }
        mediaPlayer?.start()

    }

    @SuppressLint("RemoteViewLayout", "ForegroundServiceType")
    private fun sendNotification(item: Item) {
        val nameArtists = StringBuilder().apply {
            item.artists.forEachIndexed { index, artist ->
                if (index == item.artists.size - 1) {
                    append(artist.name)
                } else {
                    append("${artist.name}, ")
                }

            }
        }
        val remoteViews: RemoteViews =
            RemoteViews(packageName, R.layout.customer_notification_layout).apply {
                setTextViewText(R.id.tv_name_song, item.name)
                setTextViewText(R.id.tv_name_artist, nameArtists)
                setImageViewResource(R.id.btn_previous, R.drawable.ic_skip_previous)
                setImageViewResource(R.id.btn_pause_or_play, R.drawable.ic_pause)
                setImageViewResource(R.id.btn_next_song, R.drawable.ic_next_music)
                setImageViewResource(R.id.img_song, R.drawable.img_artis)
            }

        val notification: Notification = NotificationCompat.Builder(this, "PLAY_MUSIC")
            .setCustomContentView(remoteViews)
            .setSmallIcon(R.drawable.ic_spotify_white)
            .build()

        startForeground(1, notification)


    }


    override fun onBind(intent: Intent): IBinder? {
        return null;
    }

    override fun onDestroy() {

//        Common.tracks = null
        super.onDestroy()


    }
}