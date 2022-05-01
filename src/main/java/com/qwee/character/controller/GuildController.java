package com.qwee.character.controller;

import com.qwee.character.entity.guild.GuildEntity;
import com.qwee.character.model.dto.request.GuildType;
import com.qwee.character.service.GuildServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/guild")
@RequiredArgsConstructor
public class GuildController {

    private final GuildServiceImpl guildService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GuildEntity> getByName(GuildType type) {
        return ResponseEntity.ok(guildService.findByName(type));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<GuildEntity> getById(@PathVariable Integer id) {
        return ResponseEntity.ok(guildService.findById(id));
    }

    @GetMapping(value = "/init")
    public void init() {
        GuildEntity guildEntity = new GuildEntity();
        guildEntity.setId(1);
        guildEntity.setDescription("desctiption");
        guildEntity.setName("WIZZARD");

        guildService.addGuild(guildEntity);
    }


}
