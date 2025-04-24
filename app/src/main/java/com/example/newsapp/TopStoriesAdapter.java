package com.example.newsapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TopStoriesAdapter extends RecyclerView.Adapter<TopStoriesAdapter.ViewHolder>{
    private List<NewsItem> topStories;
    private NewsItemClickListener clickListener;

    public TopStoriesAdapter(List<NewsItem> topStories, NewsItemClickListener clickListener) {
        this.topStories = topStories;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_top_story, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsItem newsItem = topStories.get(position);
        holder.bind(newsItem, clickListener);
    }

    @Override
    public int getItemCount() {
        return topStories.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView titleTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            titleTextView = itemView.findViewById(R.id.title_text_view);
        }

        public void bind(final NewsItem newsItem, final NewsItemClickListener clickListener) {
            titleTextView.setText(newsItem.getTitle());

            // Load image with Glide
            Glide.with(itemView.getContext())
                    .load(newsItem.getImageUrl())
                    .centerCrop()
                    .placeholder(R.drawable.placeholder_image)
                    .into(imageView);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    clickListener.onNewsItemClicked(newsItem);
                }
            });
        }
    }
}
