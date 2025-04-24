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

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder>{
    private List<NewsItem> newsList;
    private NewsItemClickListener clickListener;

    public NewsAdapter(List<NewsItem> newsList, NewsItemClickListener clickListener) {
        this.newsList = newsList;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        NewsItem newsItem = newsList.get(position);
        holder.bind(newsItem, clickListener);
    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imageView;
        private TextView titleTextView;
        private TextView descriptionTextView;
        private TextView dateTextView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.image_view);
            titleTextView = itemView.findViewById(R.id.title_text_view);
            descriptionTextView = itemView.findViewById(R.id.description_text_view);
            dateTextView = itemView.findViewById(R.id.date_text_view);
        }

        public void bind(final NewsItem newsItem, final NewsItemClickListener clickListener) {
            titleTextView.setText(newsItem.getTitle());
            descriptionTextView.setText(newsItem.getDescription());
            dateTextView.setText(newsItem.getDate());

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
