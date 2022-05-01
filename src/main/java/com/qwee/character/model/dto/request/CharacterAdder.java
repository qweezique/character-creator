package com.qwee.character.model.dto.request;

import com.qwee.character.entity.character.CharacterAttributes;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CharacterAdder {
    private Integer level = 1;
    private String name;
    private LocalDate creationDate = LocalDate.now();
    private CharacterAttributes attributes;
    private GuildType guildType;

}
