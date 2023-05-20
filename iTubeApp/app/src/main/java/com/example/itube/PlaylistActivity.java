package com.example.itube;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class PlaylistActivity extends AppCompatActivity {
    TextView textView;
    RecyclerView recyclerView;
    VerticalAdapter adapter;
    List<VideoLink> playList;
    DatabaseHelper db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playlist);
        textView = findViewById(R.id.textView);
        recyclerView = findViewById(R.id.recyclerView);
        db = new DatabaseHelper(this);
        setupList();
    }

    private void setupList() {
        playList = db.getAllPlayItems();
        adapter = new VerticalAdapter(playList, videoLink -> {
            System.out.println("Play video "+ videoLink.getUrl());
            Intent intent = new Intent(PlaylistActivity.this, VideoPlayback.class);
            intent.putExtra("url", videoLink.getUrl());
            startActivity(intent);
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.ViewHolder> {

        private List<VideoLink> videoLinkList;
        private final OnItemClickListener listener;

        public VerticalAdapter(List<VideoLink> videoLinkList, OnItemClickListener listener) {
            this.videoLinkList = videoLinkList;
            this.listener = listener;
            System.out.println("Initialized Adapter with " + videoLinkList.size());
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            private TextView titleTextView;

            public ViewHolder(View itemView) {
                super(itemView);
                titleTextView = itemView.findViewById(R.id.titleTextView);
            }

            public void bind(VideoLink videoLink, final OnItemClickListener listener) {
                titleTextView.setText(videoLink.getUrl());
                itemView.setOnClickListener(v -> listener.onItemClick(videoLink));
            }
        }
        @Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.playlist_item, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(ViewHolder holder, int position) {
            VideoLink videoLink = videoLinkList.get(position);
            holder.bind(videoLink, listener);
        }

        @Override
        public int getItemCount() {
            if(this.videoLinkList == null) {
                return 0;
            }
            return this.videoLinkList.size();
        }
    }
}