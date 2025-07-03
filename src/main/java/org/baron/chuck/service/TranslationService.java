package org.baron.chuck.service;

import org.baron.chuck.client.TranslationClient;
import org.springframework.stereotype.Service;

@Service
public class TranslationService {

    private final TranslationClient translationClient;

    public TranslationService(TranslationClient translationClient) {
        this.translationClient = translationClient;
    }

    public String translateText(String text, String targetLang) {
        return translationClient.translateText(text, "en|" + targetLang).responseData().translatedText();
    }
}
