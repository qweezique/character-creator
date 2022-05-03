package com.qwee.character.entity.character;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.qwee.character.entity.guild.GuildEntity;
import com.qwee.character.model.dto.request.GuildType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "character")
@Schema(description = "Сущность игрового персонажа")
public class CharacterEntity {

    @Id
    @SequenceGenerator(name = "character_id_gen", initialValue = 50)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "character_id_gen")
    @Column(name = "character_id")
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "level")
    private Integer level;

    @Column(name = "registration_date")
    private LocalDate registrationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "guild_id")
    @JsonBackReference
    private GuildEntity guild;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private GuildType type;

    @Column(name = "guilded")
    @Schema(description = "Вступил/Не вступил в гильдию")
    private boolean hasGuild;

    @Embedded
    private CharacterAttributes attributes;
}

