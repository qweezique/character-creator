package com.qwee.character.entity.character;

import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
public class CharacterAttributes {
    private Integer strength;
    private Integer dexterity;
    private Integer vitality;
    private Integer energy;
}
