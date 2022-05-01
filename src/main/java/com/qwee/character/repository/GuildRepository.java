package com.qwee.character.repository;

import com.qwee.character.entity.guild.GuildEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface GuildRepository extends JpaRepository<GuildEntity, Integer> {

    @Query(value = "SELECT * FROM PUBLIC.GUILD WHERE NAME = :name", nativeQuery = true)
    GuildEntity findByName(@Param("name") String name);
}
