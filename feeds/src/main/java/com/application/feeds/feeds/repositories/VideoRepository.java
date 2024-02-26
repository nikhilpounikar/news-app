package com.application.feeds.feeds.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.application.feeds.feeds.models.Video;

public interface VideoRepository extends MongoRepository<Video, String> {
    // Custom queries can be added if needed
	List<Video> findTop4ByOrderByTimestampDesc();
}

