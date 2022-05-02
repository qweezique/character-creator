package com.qwee.character.controller;

import com.qwee.character.model.dto.request.GuildType;
import com.qwee.character.service.GameServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final GameServiceImpl gameService;

    @PostMapping("/character/add-to-guild/{id}")
    public ResponseEntity<String> addToGuild(@PathVariable Integer id) {
        return ResponseEntity.ok(gameService.addCharacterToGuild(id));
    }

    @PostMapping("/character/level-up/{id}")
    public ResponseEntity<String> levelUpToCharacter(@PathVariable Integer id) {
        gameService.levelUptoCharacterById(id);
        return ResponseEntity.ok(String.format("Level up to character with id: %d", id));
    }

    @PostMapping("/guild/level-up/")
    public ResponseEntity<String> levelUpToAllCharactersInGuild(GuildType type) {
        gameService.levelUpToAllCharactersInGuild(type);
        return ResponseEntity.ok(String.format("Level up to all characters in guild type: %s", type));
    }
}
