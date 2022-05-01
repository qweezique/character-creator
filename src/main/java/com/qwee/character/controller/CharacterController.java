package com.qwee.character.controller;

import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.entity.guild.GuildEntity;
import com.qwee.character.model.dto.request.CharacterAdder;
import com.qwee.character.model.dto.request.GuildType;
import com.qwee.character.service.CharacterServiceImpl;
import com.qwee.character.service.GuildServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/character")
public class CharacterController {
    private final CharacterServiceImpl characterService;
    private final GuildServiceImpl guildService;


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


    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<CharacterEntity> addToGuild(@PathVariable Integer id) {

        CharacterEntity character = characterService.findById(id);
        character.setGuild(guildService.findByType(character.getType()));

        final CharacterEntity updatedCharacter = characterService.save(character);
        return ResponseEntity.ok(updatedCharacter);
    }
}

