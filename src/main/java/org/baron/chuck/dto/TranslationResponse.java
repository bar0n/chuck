package org.baron.chuck.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record TranslationResponse(TranslatedText responseData) {
}
