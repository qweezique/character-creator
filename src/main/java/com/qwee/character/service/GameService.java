package com.qwee.character.service;

import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.model.dto.request.GuildType;

public interface GameService {

    String addCharacterToGuild(Integer characterId);

    void levelUptoCharacterById(Integer characterId);

    void levelUpToAllCharactersInGuild(GuildType guildType);

    CharacterEntity findTopLevelCharacter();
}
