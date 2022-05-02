package com.qwee.character.controller;

import com.qwee.character.entity.guild.GuildEntity;
import com.qwee.character.model.dto.request.GuildType;
import com.qwee.character.service.GuildServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/guild")
@RequiredArgsConstructor
public class GuildController {
    private final GuildServiceImpl guildService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<GuildEntity>> getALl() {
        return ResponseEntity.ok(guildService.findAll());
    }

    @GetMapping(value = "/by", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GuildEntity> getByName(GuildType type) {
        return ResponseEntity.ok(guildService.findByType(type));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GuildEntity> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(guildService.findById(id));
    }

    @GetMapping(value = "/init")
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
    public ResponseEntity<String> changeMessageOfTheDayById(@PathVariable Integer id, @RequestBody String newMessage) {
        guildService.changeMessageOfTheDayById(id, newMessage);
        return ResponseEntity.ok(String.format("Message in guild with id: %d was changed to: %s", id, newMessage));
    }
}
