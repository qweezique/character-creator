package com.qwee.character.controller;

import com.qwee.character.model.dto.request.GuildType;
import com.qwee.character.service.GameServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.qwee.character.Constants.Controllers.GameController.*;
import static com.qwee.character.Constants.Informer.STATUS_200;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
@Tag(name = TAG, description = TAG_DESCRIPTION)
public class GameController {
    private final GameServiceImpl gameService;

    @PostMapping("/character/add-to-guild/{id}")
    @Operation(summary = ADD_TO_GUILD_SUMMARY, description = ADD_TO_GUILD_SUMMARY_DESCR)
    @ApiResponse(responseCode = STATUS_200, description = ADD_TO_GUILD_RESPONSE_DESCR)
    public ResponseEntity<String> addToGuild(@PathVariable Integer id) {
        return ResponseEntity.ok(gameService.addCharacterToGuild(id));
    }

    @PostMapping("/character/level-up/{id}")
    @Operation(summary = CHARACTER_LVL_UP_SUMMARY, description = CHARACTER_LVL_UP_SUMMARY_DESCR)
    @ApiResponse(responseCode = STATUS_200, description = CHARACTER_LVL_UP_RESPONSE_DESCR)
    public ResponseEntity<String> levelUpToCharacter(@PathVariable Integer id) {
        gameService.levelUptoCharacterById(id);
        return ResponseEntity.ok(String.format("Level up to character with id: %d", id));
    }

    @PostMapping("/guild/level-up/")
    @Operation(summary = ALL_IN_GUILD_LVL_UP_SUMMARY, description = ALL_IN_GUILD_LVL_UP_DESCR)
    @ApiResponse(responseCode = STATUS_200, description = ALL_IN_GUILD_LVL_UP_RESPONSE_DESCR)
    public ResponseEntity<String> levelUpToAllCharactersInGuild(GuildType type) {
        gameService.levelUpToAllCharactersInGuild(type);
        return ResponseEntity.ok(String.format("Level up to all characters in guild type: %s", type));
    }
}
