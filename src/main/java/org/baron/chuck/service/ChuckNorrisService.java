package org.baron.chuck.service;

import org.baron.chuck.client.ChuckNorrisClient;
import org.baron.chuck.dto.ChuckJoke;
import org.springframework.stereotype.Service;

@Service
public class ChuckNorrisService {

    private final ChuckNorrisClient chuckNorrisClient;

    public ChuckNorrisService(ChuckNorrisClient chuckNorrisClient) {
        this.chuckNorrisClient = chuckNorrisClient;
    }

    public ChuckJoke getRandomJoke() {
        return chuckNorrisClient.getRandomJoke();
    }
}
