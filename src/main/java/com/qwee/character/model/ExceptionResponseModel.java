package com.qwee.character.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import java.time.Instant;

@Schema(description = "Сущность ответа при ошибке")
@Getter
public class ExceptionResponseModel {

    @Schema(description = "Время возникновения ошибки")
    private final Instant timestamp;

    @Schema(description = "Текст ошибки")
    private final String message;

    public ExceptionResponseModel(String message) {
        this.message = message;
        this.timestamp = Instant.now();
    }
}
