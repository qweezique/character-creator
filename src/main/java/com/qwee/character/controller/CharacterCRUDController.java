package com.qwee.character.controller;

import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.model.dto.request.NewCharacterRequestDto;
import com.qwee.character.model.dto.response.CharacterResponseDto;
import com.qwee.character.service.CharacterServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.qwee.character.Constants.Controllers.CharacterCRUDController.*;
import static com.qwee.character.Constants.Informer.STATUS_200;

@RestController
@RequiredArgsConstructor
@RequestMapping("/character")
@Tag(name = TAG, description = TAG_DESCRIPTION)
public class CharacterCRUDController {
    private final CharacterServiceImpl characterService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = GET_ALL_SUMMARY)
    @ApiResponse(responseCode = STATUS_200, description = GET_ALL_RESPONSE_DESCR)
    public ResponseEntity<List<CharacterEntity>> getAll() {
        return ResponseEntity.ok(characterService.findAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = GET_BY_ID_SUMMARY)
    @ApiResponse(responseCode = STATUS_200, description = GET_BY_ID_RESPONSE_DESCR)
    public ResponseEntity<CharacterEntity> getById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(characterService.findById(id));
    }

    @GetMapping(value = "/by", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = GET_BY_NAME_SUMMARY)
    @ApiResponse(responseCode = STATUS_200, description = GET_BY_NAME_RESPONSE_DESCR)
    public ResponseEntity<CharacterEntity> getByName(@Param("name") String name) {
        return ResponseEntity.ok(characterService.findByName(name));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = CREATE_SUMMARY, description = CREATE_DESCRIPTION_SUMMARY)
    @ApiResponse(responseCode = STATUS_200, description = CREATE_RESPONSE_DESCR)
    public ResponseEntity<CharacterResponseDto> createCharacter(@RequestBody NewCharacterRequestDto newCharacterRequestDto) {
        CharacterEntity character = characterService.createCharacter(newCharacterRequestDto);

        CharacterResponseDto characterToResponse = new CharacterResponseDto();

        characterToResponse.setId(character.getId());
        characterToResponse.setName(character.getName());
        characterToResponse.setLevel(character.getLevel());
        characterToResponse.setAttributes(character.getAttributes());
        characterToResponse.setCharacterType(character.getType());
        characterToResponse.setHasGuild(character.isHasGuild());

        return ResponseEntity.ok(characterToResponse);
    }

    @DeleteMapping(value = "/del/{id}")
    @Operation(summary = DELETE_BY_ID_SUMMARY)
    @ApiResponse(responseCode = STATUS_200, description = DELETE_BY_ID_RESPONSE_DESCR)
    public ResponseEntity<String> deleteCharacter(@PathVariable Integer id) {
        characterService.deleteById(id);
        return ResponseEntity.ok(String.format("Character with id: %d deleted", id));
    }

    @DeleteMapping(value = "/del/all")
    @Operation(summary = DELETE_ALL_SUMMARY)
    @ApiResponse(responseCode = STATUS_200, description = DELETE_ALL_RESPONSE_DESCR)
    public ResponseEntity<String> deleteAllCharacters() {
        characterService.deleteAll();
        return ResponseEntity.ok("All characters was deleted");
    }

    @PatchMapping(value = "/change/name/{id}")
    @Operation(summary = CHANGE_NAME_SUMMARY, description = CHANGE_NAME_SUMMARY_DESCR)
    @ApiResponse(responseCode = STATUS_200, description = CHANGE_NAME_RESPONSE_DESCR)
    public ResponseEntity<String> changeCharacterName(@PathVariable Integer id, @RequestBody String newName) {
        characterService.changeNameById(id, newName);
        return ResponseEntity.ok(String.format("Name changed to %s", newName));
    }
}

