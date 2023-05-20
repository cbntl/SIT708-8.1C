package com.example.subtask;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;

import java.io.IOException;

public class RemoteAudioActivity extends AppCompatActivity {
    Button playButton;
    MediaPlayer mediaPlayer;
    String url = "https://download.samplelib.com/mp3/sample-9s.mp3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.internetaudio);
        playButton = findViewById(R.id.playButton);
        playButton.setOnClickListener(view -> {
            mediaPlayer = new MediaPlayer();
            try {
                mediaPlayer.setDataSource(url);
                mediaPlayer.prepare();
                mediaPlayer.start();
            }  catch (IOException e) {
            }
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