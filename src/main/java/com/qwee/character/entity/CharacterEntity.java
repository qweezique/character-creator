package com.qwee.character.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Table(name = "CHARACTER")
public class CharacterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Min(10)
    private Integer id;

    @Column(name = "NAME", nullable = true)
    private String name;

    @Column(name = "LEVEL")
    private Integer level;

    @Embedded
    private CharacterAttributes attributes;

}

