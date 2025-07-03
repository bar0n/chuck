package org.baron.chuck.controller;

import org.baron.chuck.dto.ChuckJoke;
import org.baron.chuck.service.ChuckNorrisService;
import org.baron.chuck.service.TranslationService;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class ChuckController {

    private final ChuckNorrisService chuckNorrisService;
    private final TranslationService translationService;
    private final MessageSource messageSource;

    public ChuckController(ChuckNorrisService chuckNorrisService, TranslationService translationService, MessageSource messageSource) {
        this.chuckNorrisService = chuckNorrisService;
        this.translationService = translationService;
        this.messageSource = messageSource;
    }

    @GetMapping("/")
    public String getJoke(Model model,
                          @RequestParam(value = "lang", defaultValue = "en") String lang,
                          @RequestParam(value = "originalJoke", required = false) String originalJoke) {

        String jokeToDisplay;
        String jokeToTranslate;

        Locale locale = new Locale(lang);
        LocaleContextHolder.setLocale(locale);

        if (originalJoke != null && !"en".equals(lang)) {
            // User changed language, translate the current joke
            jokeToTranslate = originalJoke;
            jokeToDisplay = translationService.translateText(jokeToTranslate, lang);
        } else {
            // Initial load or "Get Another Joke" button clicked, fetch a new joke
            ChuckJoke chuckJoke = chuckNorrisService.getRandomJoke();
            jokeToTranslate = chuckJoke.value(); // This is the new English joke

            if (!"en".equals(lang)) {
                jokeToDisplay = translationService.translateText(jokeToTranslate, lang);
            } else {
                jokeToDisplay = jokeToTranslate;
            }
        }

        model.addAttribute("joke", jokeToDisplay);
        model.addAttribute("originalJoke", jokeToTranslate); // Pass the original English joke to the view
        model.addAttribute("lang", lang);

        // Add translated static texts to the model using MessageSource
        model.addAttribute("pageTitle", messageSource.getMessage("chuck.joke.title", null, locale));
        model.addAttribute("buttonText", messageSource.getMessage("chuck.joke.button", null, locale));

        return "chuck";
    }
}

