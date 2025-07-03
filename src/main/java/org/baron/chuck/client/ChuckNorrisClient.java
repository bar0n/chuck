package org.baron.chuck.client;

import org.baron.chuck.dto.ChuckJoke;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "chuckNorrisClient", url = "https://api.chucknorris.io")
public interface ChuckNorrisClient {

    @GetMapping("/jokes/random")
    ChuckJoke getRandomJoke();
}
