package com.qwee.character.service;

import com.qwee.character.entity.guild.GuildEntity;
import com.qwee.character.model.dto.request.GuildType;
import com.qwee.character.repository.GuildRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GuildServiceImpl implements GuildService {
    private final GuildRepository guildRepository;

    @Override
    public GuildEntity findByType(GuildType guildType) {
        return guildRepository.findByName(guildType);
    }

    @Override
    public GuildEntity findById(Integer id) {
        return guildRepository.findById(id).get();
    }

    @Override
    public List<GuildEntity> findAll() {
        return guildRepository.findAll();
    }

    @Override
    public GuildEntity addGuild(GuildEntity guild) {

        return guildRepository.save(guild);
    }

    @Override
    public void save(GuildEntity guildEntity) {
        guildRepository.save(guildEntity);
    }
}
