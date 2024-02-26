package com.application.feeds.feeds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.application.feeds.feeds.models.News;
import com.application.feeds.feeds.models.Video;
import com.application.feeds.feeds.repositories.NewsRepository;
import com.application.feeds.feeds.repositories.VideoRepository;
import com.application.feeds.feeds.responses.TrendingResponse;

import java.util.List;

@RestController
@RequestMapping("/trending")
public class TrendingController {

    private final VideoRepository videoRepository;
    private final NewsRepository newsRepository;

    @Autowired
    public TrendingController(VideoRepository videoRepository, NewsRepository newsRepository) {
        this.videoRepository = videoRepository;
        this.newsRepository = newsRepository;
    }

    @GetMapping
    public ResponseEntity<TrendingResponse> getTrendingData() {
        List<Video> trendingVideos = videoRepository.findTop4ByOrderByTimestampDesc();
        List<News> trendingNews = newsRepository.findTop4ByOrderByTimestampDesc();

        TrendingResponse trendingResponse = new TrendingResponse(trendingVideos, trendingNews);

        return ResponseEntity.ok(trendingResponse);
    }
    
//    @GetMapping("/videos")
//    public ResponseEntity<List<Video>> getTrendingVideos() {
//        List<Video> trendingVideos = videoRepository.findTop4ByOrderByTimestampDesc();
//        return ResponseEntity.ok(trendingVideos);
//    }
//
//    @GetMapping("/news")
//    public ResponseEntity<List<News>> getTrendingNews() {
//        List<News> trendingNews = newsRepository.findTop4ByOrderByTimestampDesc();
//        return ResponseEntity.ok(trendingNews);
//    }
}

