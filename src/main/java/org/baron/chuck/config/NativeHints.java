package org.baron.chuck.config;

import org.springframework.aot.hint.RuntimeHints;
import org.springframework.aot.hint.RuntimeHintsRegistrar;
import org.springframework.aot.hint.TypeReference;

import static org.springframework.aot.hint.MemberCategory.INVOKE_DECLARED_CONSTRUCTORS;
import static org.springframework.aot.hint.MemberCategory.INVOKE_DECLARED_METHODS;
import static org.springframework.aot.hint.MemberCategory.DECLARED_FIELDS;

public class NativeHints implements RuntimeHintsRegistrar {

    @Override
    public void registerHints(RuntimeHints hints, ClassLoader classLoader) {
        // Hint for MessageSource properties files
        hints.resources().registerPattern("messages_*.properties");

        // Hint for ThymeleafView constructor, methods and fields
        hints.reflection().registerType(TypeReference.of("org.thymeleaf.spring6.view.ThymeleafView"), INVOKE_DECLARED_CONSTRUCTORS, INVOKE_DECLARED_METHODS, DECLARED_FIELDS);

        // Hint for org.thymeleaf.spring6.expression.Mvc$Spring41MvcUriComponentsBuilderDelegate
        hints.reflection().registerType(TypeReference.of("org.thymeleaf.spring6.expression.Mvc$Spring41MvcUriComponentsBuilderDelegate"), INVOKE_DECLARED_CONSTRUCTORS, INVOKE_DECLARED_METHODS, DECLARED_FIELDS);

        // Hint for org.thymeleaf.standard.expression.AdditionExpression
        hints.reflection().registerType(TypeReference.of("org.thymeleaf.standard.expression.AdditionExpression"), INVOKE_DECLARED_CONSTRUCTORS);
    }
}
