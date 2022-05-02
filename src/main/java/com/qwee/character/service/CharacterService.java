package com.qwee.character.service;

import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.model.dto.request.NewCharacterRequestDto;

import java.util.List;

public interface CharacterService {

    CharacterEntity findById(Integer id);

    CharacterEntity findByName(String name);

    List<CharacterEntity> findAll();

    CharacterEntity createCharacter(NewCharacterRequestDto adder);

    CharacterEntity save(CharacterEntity character);

    void deleteById(Integer id);
    void deleteAll();
    void changeNameById(Integer id, String newName);


}
