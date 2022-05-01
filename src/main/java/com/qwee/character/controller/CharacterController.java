package com.qwee.character.controller;

import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.model.dto.request.CharacterAdder;
import com.qwee.character.service.CharacterServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/character")
public class CharacterController {
    private final CharacterServiceImpl characterService;


    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterEntity> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(characterService.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<CharacterEntity>> getAll() {
        return ResponseEntity.ok(characterService.findAll());
    }


    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CharacterEntity> createCharacter(@RequestBody CharacterAdder adder){

        return ResponseEntity.ok(characterService.createCharacter(adder));
    }
}

