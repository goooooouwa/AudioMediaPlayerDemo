package com.example.mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.song)

//        val butPlay = findViewById<Button>(R.id.btnPlay)
//        butPlay.setOnClickListener {
//            if (mediaPlayer.isPlaying) {
//                mediaPlayer.pause()
//            } else {
//                mediaPlayer.start()
//            }
//        }

        val fabPlay = findViewById<FloatingActionButton>(R.id.fabPlay)
        val fabPause = findViewById<FloatingActionButton>(R.id.fabPause)
        val fabStop = findViewById<FloatingActionButton>(R.id.fabStop)

        fabPlay.setOnClickListener {
            mediaPlayer.start()
        }

        fabPause.setOnClickListener {
            mediaPlayer.pause()
        }

        fabStop.setOnClickListener {
            mediaPlayer.stop()
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}