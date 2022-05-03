package com.qwee.character.controller;

import com.qwee.character.entity.character.CharacterEntity;
import com.qwee.character.service.GameServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.qwee.character.Constants.Controllers.LadderController.*;
import static com.qwee.character.Constants.Informer.STATUS_200;

@RestController
@RequestMapping("/ladder")
@RequiredArgsConstructor
@Tag(name = TAG, description = TAG_DESCRIPTION)
public class LadderController {
    private final GameServiceImpl gameService;

    @GetMapping("/top-level-character")
    @Operation(summary = TOP_LEVEL_SUMMARY, description = TOP_LEVEL_SUMMARY_DESCR)
    @ApiResponse(responseCode = STATUS_200, description = TOP_LEVEL_SUMMARY_RESPONSE_DESCR)
    public ResponseEntity<CharacterEntity> getTopLevelCharacter() {
        return ResponseEntity.ok(gameService.findTopLevelCharacter());
    }
}
