package com.qwee.character.entity.guild;

import com.qwee.character.entity.character.CharacterEntity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.lang.Nullable;

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
    private String name;

    @Column(name = "DESCR")
    private String description;

    @OneToMany(mappedBy = "guild", cascade = CascadeType.ALL)
    private List<CharacterEntity> characters = new ArrayList<>();

}
