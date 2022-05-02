package com.qwee.character.entity.guild;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.model.dto.request.GuildType;
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
public class GuildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "guild_id")
    private Integer id;

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    private GuildType name;

    @Column(name = "description")
    private String description;

    @Column(name = "message")
    private String messageOfTheDay;

    @OneToMany(mappedBy = "guild", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    @Fetch(FetchMode.JOIN)
    @JsonManagedReference
    private List<CharacterEntity> characters = new ArrayList<>();
}