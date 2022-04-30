package com.qwee.character.repository;

import com.qwee.character.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CharacterRepository extends JpaRepository<CharacterEntity, Integer> {

    Optional<CharacterEntity> findByName(String name);

}
