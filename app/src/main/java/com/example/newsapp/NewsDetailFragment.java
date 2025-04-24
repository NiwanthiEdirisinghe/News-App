package com.example.newsapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

public class NewsDetailFragment extends Fragment {
    private static final String NEWS_ITEM = "news_item";
    private NewsItem newsItem;
    private RecyclerView relatedStoriesRecyclerView;
    private RelatedStoriesAdapter relatedStoriesAdapter;

    public static NewsDetailFragment newInstance(NewsItem newsItem) {
        NewsDetailFragment fragment = new NewsDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable(NEWS_ITEM, newsItem);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            this.newsItem = getArguments().getParcelable(NEWS_ITEM);
            //newsItem = getDummyNewsItem(newsId);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_detail, container, false);

        ImageView imageView = view.findViewById(R.id.detail_image_view);
        TextView titleTextView = view.findViewById(R.id.detail_title_text_view);
        TextView descriptionTextView = view.findViewById(R.id.detail_description_text_view);

        // Set news details
        titleTextView.setText(newsItem.getTitle());
        descriptionTextView.setText(newsItem.getContent());

        // Load image with Glide
        Glide.with(this)
                .load(newsItem.getImageUrl())
                .centerCrop()
                .placeholder(R.drawable.placeholder_image)
                .into(imageView);

        // Initialize Related Stories RecyclerView
        relatedStoriesRecyclerView = view.findViewById(R.id.related_stories_recycler_view);
        relatedStoriesRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
        relatedStoriesAdapter = new RelatedStoriesAdapter(getRelatedStories(), (NewsItemClickListener) getActivity());
        relatedStoriesRecyclerView.setAdapter(relatedStoriesAdapter);

        ImageButton backButton = view.findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> {
            requireActivity().onBackPressed();
        });

        return view;

    }

    private List<NewsItem> getRelatedStories() {
        List<NewsItem> relatedStories = new ArrayList<>();

        // Add sample related stories
        relatedStories.add(new NewsItem("r1",
                "NASA Confirms Discovery of Water on Moon's South Pole",
                "NASA announced a groundbreaking discovery confirming water molecules on the Moon’s south pole.",
                "https://i.guim.co.uk/img/media/a6ae31891ddf2cebfbf7fa6ec324c00ca46d98f8/0_0_4186_2512/master/4186.jpg?width=1200&quality=85&auto=format&fit=max&s=c616a20246e0a2d3bebb182d7746eee7",
                "This discovery opens the door for sustainable lunar missions, potentially aiding in future Mars explorations.",
                "Science",
                "2025-04-20"));

        relatedStories.add(new NewsItem("r2",
                "AI Startup Raises $500M to Compete With OpenAI",
                "A new AI company is making waves after securing major funding from tech giants.",
                "https://substackcdn.com/image/fetch/f_auto,q_auto:good,fl_progressive:steep/https%3A%2F%2Fsubstack-post-media.s3.amazonaws.com%2Fpublic%2Fimages%2Fbfd21987-8867-4569-94fc-ee0dbdbe9a09_1536x1024.png",
                "The startup aims to create a transparent and open-source alternative to proprietary AI systems.",
                "Technology",
                "2025-04-18"));

        relatedStories.add(new NewsItem("r3",
                "Olympics 2025: Paris Finalizes Preparations",
                "Paris is gearing up to host the 2025 Summer Olympics with sustainability at its core.",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTT8RsRjdQhlIooKgkDtMpxl3qCAQLl560UFMza6hAlmwmvNS9Hc5kEFt-6ItQ7wRROO48&usqp=CAU",
                "The organizing committee has confirmed that over 90% of venues are ready, promising a carbon-neutral event.",
                "Sports",
                "2025-04-17"));

        return relatedStories;
    }
}
