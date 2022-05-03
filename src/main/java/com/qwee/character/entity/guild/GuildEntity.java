package com.qwee.character.entity.guild;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.model.dto.request.GuildType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "guild")
@Schema(description = "Сущность гильдии")
public class GuildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "guild_id")
    private Integer id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    @Schema(description = "Имя гильдии определяется по персонажам, типы же которых в него могут вступить")
    private GuildType name;

    @Column(name = "description")
    @Schema(description = "Информация о гильдии, с описанием сильных и слабых сторон персонажей в ней")
    private String description;

    @Column(name = "message")
    @Schema(description = "Сообщение дня - информация для всех членов гильдии")
    private String messageOfTheDay;

    @OneToMany(mappedBy = "guild", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    @JsonManagedReference
    private List<CharacterEntity> characters = new ArrayList<>();
}