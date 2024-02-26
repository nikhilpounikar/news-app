package com.application.feeds.feeds.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.application.feeds.feeds.models.Video;

public interface CustomVideoRepository {
    Page<Video> findVideoByCustomQuery(Pageable pageable);
}
