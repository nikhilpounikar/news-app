package com.application.feeds.feeds.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.application.feeds.feeds.models.Video;

@Repository
public class VideoRepositoryImpl implements CustomVideoRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public VideoRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Page<Video> findVideoByCustomQuery(Pageable pageable) {
        Query query = new Query().with(pageable);
        List<Video> videoList = mongoTemplate.find(query, Video.class);
        long totalCount = mongoTemplate.count(query, Video.class);
        return new PageImpl<>(videoList, pageable, totalCount);
    }
}
