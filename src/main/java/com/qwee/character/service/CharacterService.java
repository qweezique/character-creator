package com.qwee.character.service;

import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.model.dto.request.CharacterAdder;

import java.util.List;

public interface CharacterService {

    CharacterEntity findById(Integer id);

    CharacterEntity findByName(String name);

    List<CharacterEntity> findAll();

    CharacterEntity createCharacter(CharacterAdder adder);

    CharacterEntity save(CharacterEntity character);
}
