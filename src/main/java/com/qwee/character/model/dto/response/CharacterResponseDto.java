package com.qwee.character.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qwee.character.entity.character.CharacterAttributes;
import com.qwee.character.model.dto.request.GuildType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "DTO ответа при создании персонажа")
public class CharacterResponseDto {
    private Integer id;
    private Integer level;
    private String name;
    private boolean hasGuild;
    @JsonProperty("character_type")
    private GuildType characterType;
    private CharacterAttributes attributes;
}
