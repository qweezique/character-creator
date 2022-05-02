package com.qwee.character.controller;

import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.service.GameServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ladder")
@RequiredArgsConstructor
public class LadderController {
    private final GameServiceImpl gameService;

    @GetMapping("/top-level-character")
    public ResponseEntity<CharacterEntity> getTopLevelCharacter() {
        return ResponseEntity.ok(gameService.findTopLevelCharacter());
    }
}
