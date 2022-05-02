package com.qwee.character.service;

import com.qwee.character.entity.guild.GuildEntity;
import com.qwee.character.model.dto.request.GuildType;

import java.util.List;

public interface GuildService {
    List<GuildEntity> findAll();

    GuildEntity findByType(GuildType guildType);

    GuildEntity findById(Integer id);

    GuildEntity addGuild(GuildEntity guild);

    void changeMessageOfTheDayById(Integer id, String newMessage);

    void save(GuildEntity guildEntity);
}
