package com.qwee.character.model.dto.request;

import com.qwee.character.entity.character.CharacterAttributes;
import lombok.Data;

@Data
public class CharacterAdder {
    private String name;
    private CharacterAttributes attributes;
    private GuildType guildType;

}
