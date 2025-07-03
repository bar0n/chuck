package org.baron.chuck.service;

import org.baron.chuck.dto.ChuckJoke;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChuckNorrisService {

    private final RestTemplate restTemplate;
    private static final String CHUCK_NORRIS_API_URL = "https://api.chucknorris.io/jokes/random";

    public ChuckNorrisService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public ChuckJoke getRandomJoke() {
        return restTemplate.getForObject(CHUCK_NORRIS_API_URL, ChuckJoke.class);
    }
}
