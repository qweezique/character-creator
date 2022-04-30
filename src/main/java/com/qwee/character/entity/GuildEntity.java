package com.qwee.character.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "GUILD")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class GuildEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "GUILD_NAME", nullable = true)
    private String name;


}
