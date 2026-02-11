package org.acme.dto;

import jakarta.json.bind.annotation.JsonbProperty;

public record MijoCounterDTO(
        @JsonbProperty("count")
        Integer count,

        @JsonbProperty("name")
        String name
) {
}
