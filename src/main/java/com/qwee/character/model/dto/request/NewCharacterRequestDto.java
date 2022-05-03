package com.qwee.character.model.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.qwee.character.entity.character.CharacterAttributes;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDate;

@Data
@Schema(description = "DTO необходимых минимальных данных для создания персонажа ")
public class NewCharacterRequestDto {

    @JsonIgnore
    @Schema(minimum = "1", defaultValue = "1", description = "Начальный уровень персонажа")
    private Integer level = 1;

    @Schema(description = "Имя персонажа (можно будет изменить в дальнейшем)", example = "Nikita")
    private String name;

    @JsonIgnore
    @Schema(description = "Дата создания персонажа")
    private LocalDate creationDate = LocalDate.now();

    @JsonIgnore
    @Schema(description = "Основные характеристики персонажа; иницилизируются определенном образом в заивисимости от типа игрвоого персонажа")
    private CharacterAttributes attributes;

    @Schema(description = "Тип игрвого персонажа, определяющий его начальные характеристики и гильдию, в которую можно будет вступить")
    private GuildType type;
}
