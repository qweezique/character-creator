package com.qwee.character.service;


import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.model.dto.request.GuildType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class GameServiceImpl implements GameService {

    private final CharacterServiceImpl characterService;
    private final GuildServiceImpl guildService;

    @Override
    public String addCharacterToGuild(Integer characterId) {

        CharacterEntity character = characterService.findById(characterId);
        GuildType type = character.getType();
        String name = character.getName();

        character.setGuild(guildService.findByType(type));
        character.setGuiled(true);
        characterService.save(character);

        return String.format("Character with name %s was confirmed in his own guild: %s", name, type);

    }
}
