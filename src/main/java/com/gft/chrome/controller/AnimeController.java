package com.gft.chrome.controller;

import com.gft.chrome.service.AnimeService;
import com.gft.chrome.vo.Data;
import com.gft.chrome.vo.SingleAnime;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/anime")
public class AnimeController {

    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public Flux<Data> getAnimes() {
        return animeService.getAnimes();
    }

    @GetMapping("/{id}")
    public Mono<SingleAnime> getAnime(@PathVariable Integer id) {
        return animeService.getAnime(id);
    }
}
