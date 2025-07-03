package org.baron.chuck.dto;

import org.springframework.aot.hint.annotation.RegisterReflectionForBinding;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
@RegisterReflectionForBinding
public record TranslatedText(String translatedText) {
}
