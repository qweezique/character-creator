package com.qwee.character.service;

import com.qwee.character.entity.CharacterEntity;
import com.qwee.character.exception.NoCharacterException;
import com.qwee.character.repository.CharacterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;

    @Override
    public CharacterEntity findById(Integer id) {
        return characterRepository.findById(id).orElseThrow(() -> new NoCharacterException("Character with id " + id + " not found"));
    }
}
