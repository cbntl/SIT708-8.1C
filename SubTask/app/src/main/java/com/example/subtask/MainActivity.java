package com.example.subtask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button localAudioButton;
    Button cameraAppButton;
    Button playAudioURLButton;
    Button playVideoButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menupage);
        localAudioButton = findViewById(R.id.localAudioButton);
        cameraAppButton = findViewById(R.id.cameraAppButton);
        playAudioURLButton = findViewById(R.id.playAudioURLButton);
        playVideoButton = findViewById(R.id.playVideoButton);
        localAudioButton.setOnClickListener(view -> {
            handleLocalAudio();
        });
        cameraAppButton.setOnClickListener(view -> {
            handleCameraApp();
        });
        playAudioURLButton.setOnClickListener(view -> {
            handleRemoteAudio();
        });
        playVideoButton.setOnClickListener(view -> {
            handleRemoteVideo();
        });
    }

    private void handleLocalAudio() {
        Intent i= new Intent(MainActivity.this,LocalAudioActivity.class);
        startActivity(i);
    }
    private void handleCameraApp() {
        Intent i= new Intent(MainActivity.this,CameraActivity.class);
        startActivity(i);
    }
    private void handleRemoteAudio() {
        Intent i= new Intent(MainActivity.this,RemoteAudioActivity.class);
        startActivity(i);
    }
    private void handleRemoteVideo() {
        Intent i= new Intent(MainActivity.this,RemoteVideoActivity.class);
        startActivity(i);
    }
}