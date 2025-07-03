package org.baron.chuck.service;

import org.baron.chuck.dto.TranslationResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TranslationService {

    private final RestTemplate restTemplate;
    private static final String MY_MEMORY_API_URL = "https://api.mymemory.translated.net/get?q=%s&langpair=en|%s";

    public TranslationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String translateText(String text, String targetLang) {
        String url = String.format(MY_MEMORY_API_URL, text, targetLang);
        TranslationResponse translationResponse = restTemplate.getForObject(url, TranslationResponse.class);
        return translationResponse.responseData().translatedText();
    }
}
