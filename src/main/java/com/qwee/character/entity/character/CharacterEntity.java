package com.qwee.character.entity.character;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.qwee.character.entity.guild.GuildEntity;
import com.qwee.character.model.dto.request.GuildType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "CHARACTER")
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CHARACTER_ID")
    private Integer id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "LEVEL")
    private Integer level;

    @Column(name = "REGISTRATION_DATE")
    private LocalDate registrationDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private GuildEntity guild;

    @Column(name = "type")
    private GuildType type;

    @Embedded
    private CharacterAttributes attributes;
}

