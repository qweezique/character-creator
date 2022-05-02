package com.qwee.character.entity.character;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.qwee.character.entity.guild.GuildEntity;
import com.qwee.character.model.dto.request.GuildType;
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
public class CharacterEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
    private boolean isGuiled;

    @Embedded
    private CharacterAttributes attributes;
}

