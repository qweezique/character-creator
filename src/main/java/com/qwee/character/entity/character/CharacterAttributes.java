package com.qwee.character.entity.character;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.persistence.Embeddable;

@Embeddable
@Data
@Schema(description = "Основные характеристика персонажа")
public class CharacterAttributes {
    @Schema(description = "Сила")
    private Integer strength;
    @Schema(description = "Ловкость")
    private Integer dexterity;
    @Schema(description = "Живучесть")
    private Integer vitality;
    @Schema(description = "Энергия")
    private Integer energy;
}
