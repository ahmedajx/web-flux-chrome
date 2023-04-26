package com.gft.chrome.service;

import com.gft.chrome.vo.Data;
import com.gft.chrome.vo.SingleAnime;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AnimeService {

    private final WebClient webClient;

    public AnimeService(WebClient webClient) {
        this.webClient = webClient;
    }

    public Flux<Data> getAnimes() {
        return webClient.get()
                .uri("anime?page[limit]=20")
                .retrieve()
                .bodyToFlux(Data.class);
    }

    public Mono<SingleAnime> getAnime(Integer id) {
        return webClient.get()
                .uri("anime/{id}", id)
                .retrieve()
                .bodyToMono(SingleAnime.class);
    }
}
