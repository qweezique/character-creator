package com.qwee.character.service;

import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.exception.NoCharacterException;
import com.qwee.character.repository.CharacterRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class CharacterServiceImplTest {

    public static final String KNIGHT_NAME = "Paladin";
    public static final int WIZZARD_ID = 1;
    public static final int WIZZARD_LVL = 5;
    public static final String WIZZARD_NAME = "Witch";
    public static final int KNIGHT_LVL = 2;
    public static final int KNIGHT_ID = 2;
    public static final int NOT_FOUND_ID = 323232;
    @Mock
    private CharacterRepository repository;

    @InjectMocks
    private CharacterServiceImpl service;

    private CharacterEntity character_wizzard;
    private CharacterEntity character_knight;
    private List<CharacterEntity> characters;

    @BeforeEach
    void init() {
        character_wizzard = new CharacterEntity();
        character_knight = new CharacterEntity();

        character_wizzard.setName(WIZZARD_NAME);
        character_wizzard.setLevel(WIZZARD_LVL);
        character_wizzard.setId(WIZZARD_ID);

        character_knight.setName(KNIGHT_NAME);
        character_knight.setLevel(KNIGHT_LVL);
        character_knight.setId(KNIGHT_ID);

        characters = List.of(character_wizzard, character_knight);
    }

    @Test
    void findById() {
        Mockito.when(repository.findById(WIZZARD_ID)).thenReturn(Optional.of(character_wizzard));
        CharacterEntity byId = service.findById(WIZZARD_ID);

        assertEquals(character_wizzard, byId);
        assertEquals(character_wizzard.getLevel(), byId.getLevel());
    }

    @Test
    void findByName() {
        Mockito.when(repository.findByName(KNIGHT_NAME)).thenReturn(Optional.of(character_knight));
        CharacterEntity byName = service.findByName(KNIGHT_NAME);

        assertEquals(character_knight, byName);
        assertEquals(character_knight.getName(), byName.getName());
    }

    @Test
    void findAll() {
        Mockito.when(repository.findAll()).thenReturn(characters);
        List<CharacterEntity> all = service.findAll();
        assertEquals(characters, all);
    }

    @Test
    void throwNoCharacterException() {
        Mockito.when(repository.findById(NOT_FOUND_ID)).thenThrow(NoCharacterException.class);
        assertThrows(NoCharacterException.class, () -> service.findById(NOT_FOUND_ID));
    }
}