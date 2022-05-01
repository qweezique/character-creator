package com.qwee.character.entity.guild;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.model.dto.request.GuildType;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
@Table(name = "GUILD")
public class GuildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "GUILD_ID")
    private Integer id;

    @Column(name = "NAME")
    @Enumerated(EnumType.STRING)
    private GuildType name;

    @Column(name = "DESCR")
    private String description;

    @OneToMany(mappedBy = "guild", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    @JsonManagedReference
    private List<CharacterEntity> characters = new ArrayList<>();
}
