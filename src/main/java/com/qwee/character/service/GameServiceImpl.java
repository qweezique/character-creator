package com.qwee.character.service;


import com.qwee.character.entity.character.CharacterAttributes;
import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.exception.NoElementsException;
import com.qwee.character.model.dto.request.GuildType;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

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
        character.setHasGuild(true);
        characterService.save(character);

        return String.format("Character with name %s was confirmed in his own guild: %s", name, type);
    }

    @Override
    public void levelUptoCharacterById(Integer characterId) {
        CharacterEntity character = characterService.findById(characterId);
        levelUpAndUpAttributesToCharacter(character);
        characterService.save(character);
    }

    @Override
    public void levelUpToAllCharactersInGuild(GuildType guildType) {
        List<CharacterEntity> characters = guildService.findByType(guildType).getCharacters();
        characters.forEach(character -> {
            levelUpAndUpAttributesToCharacter(character);
            characterService.save(character);
        });
    }

    @Override
    public CharacterEntity findTopLevelCharacter() {
        List<CharacterEntity> all = characterService.findAll();
       return all.stream().max(Comparator.comparing(CharacterEntity::getLevel)).orElseThrow(()-> new NoElementsException("Список пуст"));
    }

    private CharacterEntity levelUpAndUpAttributesToCharacter(CharacterEntity character) {
        character.setLevel(character.getLevel() + 1);
        CharacterAttributes attributes = character.getAttributes();
        attributes.setStrength(attributes.getStrength() * 2);
        attributes.setDexterity(attributes.getDexterity() * 2);
        attributes.setVitality(attributes.getVitality() * 2);
        attributes.setEnergy(attributes.getEnergy() * 2);
        return character;
    }
}
