package com.example.newsapp;

import android.os.Parcel;
import android.os.Parcelable;

public class NewsItem  implements Parcelable {
    private String id;
    private String title;
    private String description;
    private String imageUrl;
    private String content;
    private String category;
    private String date;

    public NewsItem(String id, String title, String description, String imageUrl, String content, String category, String date) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
        this.content = content;
        this.category = category;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getContent() {
        return content;
    }

    public String getCategory() {
        return category;
    }

    public String getDate() {
        return date;
    }

    protected NewsItem(Parcel in) {
        id = in.readString();
        title = in.readString();
        description = in.readString();
        imageUrl = in.readString();
        content = in.readString();
        category = in.readString();
        date = in.readString();
    }

    public static final Creator<NewsItem> CREATOR = new Creator<NewsItem>() {
        @Override
        public NewsItem createFromParcel(Parcel in) {
            return new NewsItem(in);
        }

        @Override
        public NewsItem[] newArray(int size) {
            return new NewsItem[size];
        }
    };

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(title);
        dest.writeString(description);
        dest.writeString(imageUrl);
        dest.writeString(content);
        dest.writeString(category);
        dest.writeString(date);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
