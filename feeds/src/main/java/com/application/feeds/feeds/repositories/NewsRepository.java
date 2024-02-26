package com.application.feeds.feeds.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.application.feeds.feeds.models.News;

public interface NewsRepository extends MongoRepository<News, String>, CustomNewsRepository {
    // Custom queries can be added if needed
	 List<News> findTop4ByOrderByTimestampDesc();
}

