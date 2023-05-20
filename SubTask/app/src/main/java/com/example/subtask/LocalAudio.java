package com.example.subtask;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

public class LocalAudioActivity extends AppCompatActivity {

    Button playButton;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.localaudio);
        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(view -> {
            mediaPlayer = MediaPlayer.create(LocalAudioActivity.this, R.raw.sample_audio);
            mediaPlayer.start();
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        if (mediaPlayer != null) {
            mediaPlayer.stop();
        }
    }
}