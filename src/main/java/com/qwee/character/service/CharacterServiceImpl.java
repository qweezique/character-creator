package com.qwee.character.service;

import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.exception.NoCharacterException;
import com.qwee.character.exception.NoElementsException;
import com.qwee.character.model.dto.request.CharacterAdder;
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
    public List<CharacterEntity> findAll() {
        List<CharacterEntity> all = characterRepository.findAll();
        if (all.isEmpty()) {
            throw new NoElementsException("Not one Character is not in the database");
        }
        return all;
    }

    @Override
    public CharacterEntity add(CharacterAdder characterAdder) {
        return null;
    }
}
