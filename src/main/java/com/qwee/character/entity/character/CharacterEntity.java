package com.qwee.character.entity.character;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "GUILD_ID")
    @JsonBackReference
    private GuildEntity guild;

    @Column(name = "TYPE")
    @Enumerated(EnumType.STRING)
    private GuildType type;

    @Embedded
    private CharacterAttributes attributes;
}

