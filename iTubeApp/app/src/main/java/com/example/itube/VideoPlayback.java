package com.example.itube;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener;
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.views.YouTubePlayerView;

//https://github.com/PierfrancescoSoffritti/android-youtube-player

public class VideoPlayback extends AppCompatActivity {
    YouTubePlayerView youtubePlayerView;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.videoplayback);
        youtubePlayerView = findViewById(R.id.youtubePlayerView);
        url = (String) getIntent().getSerializableExtra("url");
        getLifecycle().addObserver(youtubePlayerView);
        youtubePlayerView.addYouTubePlayerListener(new AbstractYouTubePlayerListener() {
            @Override
            public void onReady(@NonNull YouTubePlayer youTubePlayer) {
                YouTubeHelper helper = new YouTubeHelper();
                String videoId = helper.extractVideoIdFromUrl(url);
                System.out.println("videoId: "+videoId+" url: "+url);
                youTubePlayer.loadVideo(videoId, 0);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}