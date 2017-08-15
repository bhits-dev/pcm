package gov.samhsa.c2s.pcm.domain;

import com.google.common.base.CaseFormat;

import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public interface I18nEnabled {
    String DELIMITER = ".";
    String EMPTY_STRING = "";

    default String getMessageKey(String fieldName) {
        return Stream.of(
                CaseFormat.UPPER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, this.getClass().getSimpleName()),
                getIdAsString(),
                CaseFormat.LOWER_CAMEL.to(CaseFormat.UPPER_UNDERSCORE, fieldName))
                .collect(joining(DELIMITER));
    }

    default String longToString(Long longNumber) {
        return Optional.ofNullable(longNumber).map(l -> l.toString()).orElse(EMPTY_STRING);
    }

    String getIdAsString();
}
