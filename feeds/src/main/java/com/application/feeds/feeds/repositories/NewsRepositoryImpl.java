package com.application.feeds.feeds.repositories;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.application.feeds.feeds.models.News;

@Repository
public class NewsRepositoryImpl implements CustomNewsRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public NewsRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Page<News> findNewsByCustomQuery(Pageable pageable) {
        Query query = new Query().with(pageable);
        List<News> newsList = mongoTemplate.find(query, News.class);
        long totalCount = mongoTemplate.count(query, News.class);
        return new PageImpl<>(newsList, pageable, totalCount);
    }
}
