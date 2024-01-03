package com.realstar.videostreaming.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import reactor.core.publisher.Mono;
import com.realstar.videostreaming.service.StreamingService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StreamingController {
    @Autowired
    private StreamingService streamingService;

    @GetMapping(value = "/video/{title}", produces = "video/mp4")
    public Mono<Resource> streamVideos(@PathVariable String title, @RequestHeader("Range") String range) {
        log.info("Range in bytes : " + range);
        return streamingService.getVideo(title);
    }
}
