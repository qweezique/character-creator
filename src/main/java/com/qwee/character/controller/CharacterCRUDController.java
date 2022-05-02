package com.qwee.character.controller;

import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.model.dto.request.CharacterAdder;
import com.qwee.character.service.CharacterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/character")
public class CharacterCRUDController {
    private final CharacterServiceImpl characterService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CharacterEntity>> getAll() {
        return ResponseEntity.ok(characterService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterEntity> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(characterService.findById(id));
    }

    @GetMapping(value = "/by", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterEntity> getByName(@Param("name") String name) {
        return ResponseEntity.ok(characterService.findByName(name));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterEntity> createCharacter(@RequestBody CharacterAdder adder) {
        return ResponseEntity.ok(characterService.createCharacter(adder));
    }

    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity<String> deleteCharacter(@PathVariable Integer id) {
        characterService.deleteById(id);
        return ResponseEntity.ok(String.format("Character with id: %d deleted", id));
    }

    @PatchMapping(value = "/change/name/{id}")
    public ResponseEntity<String> changeCharacterName(@PathVariable Integer id, @RequestBody String newName) {
        characterService.changeNameById(id, newName);
        return ResponseEntity.ok(String.format("Name changed to %s", newName));
    }
}

