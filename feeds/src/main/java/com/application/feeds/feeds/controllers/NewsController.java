package com.application.feeds.feeds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.application.feeds.feeds.models.News;
import com.application.feeds.feeds.repositories.NewsRepository;


@RestController
@RequestMapping("/news")
public class NewsController {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsController(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @GetMapping()
    public ResponseEntity<Page<News>> getAllNews(@RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam(defaultValue = "10") int pageSize) {
    	System.out.println(pageNumber+" "+pageSize);
    	Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Page<News> newsPage = newsRepository.findAll(pageable);
        return ResponseEntity.ok(newsPage);
    }
    
    @PostMapping
    public ResponseEntity<String> addNews(@RequestBody News news) {
        News addedNews = newsRepository.save(news);
        return new ResponseEntity<>(addedNews.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteNews(@PathVariable String id) {
        if (newsRepository.existsById(id)) {
            newsRepository.deleteById(id);
            return new ResponseEntity<>("News deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("News not found", HttpStatus.NOT_FOUND);
        }
    }
}

