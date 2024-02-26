package com.application.feeds.feeds.responses;

import java.util.List;

import com.application.feeds.feeds.models.News;
import com.application.feeds.feeds.models.Video;

public class TrendingResponse {
    private List<Video> trendingVideos;
    private List<News> trendingNews;

    // Constructors, getters, setters, etc.

    public TrendingResponse(List<Video> trendingVideos, List<News> trendingNews) {
        this.trendingVideos = trendingVideos;
        this.trendingNews = trendingNews;
    }

    public List<Video> getTrendingVideos() {
        return trendingVideos;
    }

    public void setTrendingVideos(List<Video> trendingVideos) {
        this.trendingVideos = trendingVideos;
    }

    public List<News> getTrendingNews() {
        return trendingNews;
    }

    public void setTrendingNews(List<News> trendingNews) {
        this.trendingNews = trendingNews;
    }
}

