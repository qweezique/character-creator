package com.qwee.character.model.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qwee.character.entity.character.CharacterAttributes;
import lombok.Data;

import java.time.LocalDate;

@Data
public class NewCharacterRequestDto {

    @JsonIgnore
    private Integer level = 1;

    private String name;

    @JsonIgnore
    private LocalDate creationDate = LocalDate.now();

    @JsonIgnore
    private CharacterAttributes attributes;

    private GuildType type;
}
