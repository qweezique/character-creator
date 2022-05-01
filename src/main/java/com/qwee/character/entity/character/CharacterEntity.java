package com.qwee.character.entity.character;

import com.qwee.character.entity.guild.GuildEntity;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CHARACTER_GUILD_ID")
    private GuildEntity guild;

    @Embedded
    private CharacterAttributes attributes;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CharacterEntity that = (CharacterEntity) o;
        return id.equals(that.id) && name.equals(that.name) && Objects.equals(level, that.level) && Objects.equals(registrationDate, that.registrationDate) && Objects.equals(guild, that.guild) && attributes.equals(that.attributes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, level, registrationDate, guild, attributes);
    }
}

