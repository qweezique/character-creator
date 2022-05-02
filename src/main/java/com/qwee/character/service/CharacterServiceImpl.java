package com.qwee.character.service;

import com.qwee.character.entity.character.CharacterAttributes;
import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.exception.NoCharacterException;
import com.qwee.character.exception.NoElementsException;
import com.qwee.character.model.dto.request.GuildType;
import com.qwee.character.model.dto.request.NewCharacterRequestDto;
import com.qwee.character.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;

    @Override
    public CharacterEntity findById(Integer id) {
        return characterRepository.findById(id).orElseThrow(() -> new NoCharacterException("Character with id " + id + " not found"));
    }

    @Override
    public CharacterEntity findByName(String name) {
        return characterRepository.findByName(name).orElseThrow(() -> new NoCharacterException("Character with name " + name + "not found"));
    }

    @Override
    public List<CharacterEntity> findAll() {
        List<CharacterEntity> all = characterRepository.findAll();
        if (all.isEmpty()) {
            throw new NoElementsException("Not one Character is not in the database");
        }
        return all;
    }

    @Override
    public CharacterEntity createCharacter(NewCharacterRequestDto adder) {

        GuildType typeFromRequest = adder.getType();

        CharacterAttributes characterAttributes = new CharacterAttributes();
        characterAttributes.setStrength(typeFromRequest.getStrength());
        characterAttributes.setDexterity(typeFromRequest.getDexterity());
        characterAttributes.setVitality(typeFromRequest.getVitality());
        characterAttributes.setEnergy(typeFromRequest.getEnergy());

        CharacterEntity character = new CharacterEntity();
        character.setAttributes(characterAttributes);
        character.setType(adder.getType());
        character.setName(adder.getName());
        character.setRegistrationDate(adder.getCreationDate());
        character.setLevel(adder.getLevel());
        character.setHasGuild(false);

        return characterRepository.save(character);
    }

    @Override
    public CharacterEntity save(CharacterEntity character) {
        return characterRepository.save(character);
    }

    @Override
    public void deleteById(Integer id) {
        characterRepository.delete(findById(id));
    }

    @Override
    public void changeNameById(Integer id, String newName) {
        CharacterEntity character = findById(id);
        character.setName(newName);
        characterRepository.save(character);
    }
}
