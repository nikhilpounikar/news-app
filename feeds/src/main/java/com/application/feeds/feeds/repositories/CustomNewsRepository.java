package com.application.feeds.feeds.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.application.feeds.feeds.models.News;

public interface CustomNewsRepository {
    Page<News> findNewsByCustomQuery(Pageable pageable);
}
