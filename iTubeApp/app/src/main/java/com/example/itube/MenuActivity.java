package com.example.itube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.UUID;

public class MenuActivity extends AppCompatActivity {
    TextView titleTextView;
    EditText youtubeLink;
    Button playButton;
    Button addToPlayListButton;
    Button viewPlaylistButton;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menupage);
        titleTextView = findViewById(R.id.titleTextView);
        youtubeLink = findViewById(R.id.youtubeLink);
        playButton = findViewById(R.id.playButton);
        addToPlayListButton = findViewById(R.id.addToPlayListButton);
        viewPlaylistButton = findViewById(R.id.viewPlaylistButton);
        db = new DatabaseHelper(this);

        playButton.setOnClickListener(view -> {
            playButtonPressHandle();
        });
        addToPlayListButton.setOnClickListener(view -> {
            addToPlaylist();
        });
        viewPlaylistButton.setOnClickListener(view -> {
            Intent intent = new Intent(MenuActivity.this, PlaylistActivity.class);
            startActivity(intent);
        });
    }

    private void playButtonPressHandle() {
        String url = youtubeLink.getText().toString();
        if (url.matches("")) {
            showToast("Please enter a URL");
            return;
        }
        Intent intent = new Intent(MenuActivity.this, VideoPlayback.class);
        intent.putExtra("url", url);
        startActivity(intent);
    }

    private void addToPlaylist() {
        String url = youtubeLink.getText().toString();
        if (url.matches("")) {
            showToast("Please enter a URL");
            return;
        }
        VideoLink videoLink = new VideoLink(UUID.randomUUID().toString(), url);
        Boolean success = db.addtoPlaylist(videoLink);
        if (success) {
            showToast("Successfully added to playlist");
            youtubeLink.setText("");
        } else {
            showToast("Failed to add to playlist");
        }
    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}