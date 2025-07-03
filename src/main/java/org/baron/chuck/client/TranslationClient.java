package org.baron.chuck.client;

import org.baron.chuck.dto.TranslationResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "translationClient", url = "https://api.mymemory.translated.net")
public interface TranslationClient {

    @GetMapping("/get")
    TranslationResponse translateText(@RequestParam("q") String text, @RequestParam("langpair") String langpair);
}
