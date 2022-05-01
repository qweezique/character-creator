package com.qwee.character.service;

import com.qwee.character.entity.guild.GuildEntity;
import com.qwee.character.model.dto.request.GuildType;
import com.qwee.character.repository.GuildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GuildServiceImpl implements GuildService {
    private final GuildRepository guildRepository;

    @Override
    public GuildEntity findByName(GuildType guildType) {
        return guildRepository.findByName(guildType.name());
    }

    @Override
    public GuildEntity findById(Integer id) {
        return guildRepository.findById(id).get();
    }

    @Override
    public GuildEntity addGuild(GuildEntity guild) {

        return guildRepository.save(guild);
    }
}
