package com.qwee.character.controller;

import com.qwee.character.entity.guild.GuildEntity;
import com.qwee.character.model.dto.request.GuildType;
import com.qwee.character.service.GuildServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.qwee.character.Constants.Controllers.GuildController.*;
import static com.qwee.character.Constants.Informer.STATUS_200;

@RestController
@RequestMapping("/guild")
@RequiredArgsConstructor
@Tag(name = TAG, description = TAG_DESCRIPTION)
public class GuildController {
    private final GuildServiceImpl guildService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = GET_ALL_SUMMARY)
    @ApiResponse(responseCode = STATUS_200, description = GET_ALL_RESPONSE_DESCR)
    ResponseEntity<List<GuildEntity>> getALl() {
        return ResponseEntity.ok(guildService.findAll());
    }

    @GetMapping(value = "/by", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = GET_BY_NAME_SUMMARY, description = GET_BY_NAME_SUMMARY_DESCR)
    @ApiResponse(responseCode = STATUS_200, description = GET_BY_NAME_RESPONSE_DESCR)
    ResponseEntity<GuildEntity> getByName(GuildType type) {
        return ResponseEntity.ok(guildService.findByType(type));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(summary = GET_BY_ID_SUMMARY)
    @ApiResponse(responseCode = STATUS_200, description = GET_BY_ID_RESPONSE_DESCR)
    ResponseEntity<GuildEntity> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(guildService.findById(id));
    }

    @GetMapping(value = "/init")
    @Operation(summary = INIT_SUMMARY, description = INIT_SUMMARY_DESCR)
    @ApiResponse(responseCode = STATUS_200, description = INIT_SUMMARY_RESPONSE_DESCR)
    public ResponseEntity<List<GuildEntity>> init() {
        GuildEntity wizzardGuild = new GuildEntity();
        wizzardGuild.setDescription("Волшебнкии обладают высоким интеллектом, но слабы в ближних боях");
        wizzardGuild.setName(GuildType.WIZZARD);
        wizzardGuild.setMessageOfTheDay("На сервере особый ивент: повышен дроп вещей для волшебников");
        guildService.addGuild(wizzardGuild);

        GuildEntity knightGuild = new GuildEntity();
        knightGuild.setDescription("Зачем нужен интеллект, если есть сила о отвага?");
        knightGuild.setMessageOfTheDay("Все собираемся в городе для обсуждения стратегии");
        knightGuild.setName(GuildType.KNIGHT);
        guildService.addGuild(knightGuild);

        GuildEntity thiefGuild = new GuildEntity();
        thiefGuild.setDescription("Хочешь жить - умей вертеться; у воров повышенная ловкость");
        thiefGuild.setMessageOfTheDay("Все на поиске редкого артефакта!");
        thiefGuild.setName(GuildType.THIEF);
        guildService.addGuild(thiefGuild);

        return ResponseEntity.ok(List.of(wizzardGuild, knightGuild, thiefGuild));
    }

    @PatchMapping(value = "/change/message/{id}")
    @Operation(summary = CHANGE_MESSAGE_SUMMARY, description = CHANGE_MESSAGE_DESCR)
    @ApiResponse(responseCode = STATUS_200, description = CHANGE_MESSAGE_RESPONSE_DESCR)
    public ResponseEntity<String> changeMessageOfTheDayById(@PathVariable Integer id, @RequestBody String newMessage) {
        guildService.changeMessageOfTheDayById(id, newMessage);
        return ResponseEntity.ok(String.format("Message in guild with id: %d was changed to: %s", id, newMessage));
    }
}
