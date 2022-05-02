package com.qwee.character.controller;

import com.qwee.character.service.GameServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final GameServiceImpl gameService;

    @PostMapping("/addToGuild/{id}")
    public ResponseEntity<String> addToGuild(@PathVariable Integer id) {
        return ResponseEntity.ok(gameService.addCharacterToGuild(id));
    }
}
