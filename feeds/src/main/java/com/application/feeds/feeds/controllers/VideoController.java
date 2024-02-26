package com.application.feeds.feeds.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.application.feeds.feeds.models.Video;
import com.application.feeds.feeds.repositories.VideoRepository;


@RestController
@RequestMapping("/videos")
public class VideoController {

    private final VideoRepository videoRepository;

    @Autowired
    public VideoController(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @GetMapping
    public ResponseEntity<Page<Video>> getAllNews(@RequestParam(defaultValue = "1") int pageNumber,
            @RequestParam(defaultValue = "3") int pageSize) {
    	
    	Pageable pageable = PageRequest.of(pageNumber, pageSize,Sort.by(Sort.Direction.ASC, "id"));
        Page<Video> videoPage = videoRepository.findAll(pageable);
        return ResponseEntity.ok(videoPage);
    }

    @PostMapping
    public ResponseEntity<String> addVideo(@RequestBody Video video) {
        Video responseVideo = videoRepository.save(video);
        return new ResponseEntity<>(responseVideo.getId(), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVideo(@PathVariable String id) {
        if (videoRepository.existsById(id)) {
            videoRepository.deleteById(id);
            return new ResponseEntity<>("Video deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Video not found", HttpStatus.NOT_FOUND);
        }
    }
}
