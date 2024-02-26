package com.application.feeds.feeds.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "videos")
public class Video {
    @Id
    private String id;

    private String thumbnail;
    private long timestamp;
    private long duration;

    // Additional fields (you can add more as needed)
    private String title;
    private String description;
    // Add other fields as needed

    // Constructors, getters, setters
    public Video() {
    }

    public Video(String thumbnail, long timestamp, long duration, String title, String description) {
        this.thumbnail = thumbnail;
        this.timestamp = timestamp;
        this.duration = duration;
        this.title = title;
        this.description = description;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Override toString() method for debugging purposes
    @Override
    public String toString() {
        return "Video{" +
                "id='" + id + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", timestamp=" + timestamp +
                ", duration=" + duration +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}

