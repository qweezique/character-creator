package com.qwee.character.controller;

import com.qwee.character.service.GameServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/game")
@RequiredArgsConstructor
public class GameController {
    private final GameServiceImpl gameService;

    @PutMapping("/addToGuild/{id}")
    public ResponseEntity<String> addToGuild(@PathVariable Integer id) {
        return ResponseEntity.ok(gameService.addCharacterToGuild(id));
    }
}
