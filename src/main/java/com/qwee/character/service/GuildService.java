package com.qwee.character.service;

import com.qwee.character.entity.guild.GuildEntity;
import com.qwee.character.model.dto.request.GuildType;

public interface GuildService {
    GuildEntity findByName(GuildType guildType);
    GuildEntity findById(Integer id);
    GuildEntity addGuild(GuildEntity guild);

}
