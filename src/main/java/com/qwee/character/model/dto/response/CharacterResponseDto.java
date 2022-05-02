package com.qwee.character.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qwee.character.entity.character.CharacterAttributes;
import com.qwee.character.model.dto.request.GuildType;
import lombok.Data;

@Data
public class CharacterResponseDto {
    private Integer id;
    private Integer level;
    private String name;
    private boolean hasGuild;
    @JsonProperty("character_type")
    private GuildType characterType;
    private CharacterAttributes attributes;
}
