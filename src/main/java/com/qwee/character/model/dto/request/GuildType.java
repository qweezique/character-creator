package com.qwee.character.model.dto.request;

public enum GuildType {

    WIZZARD(25, 35, 40, 140),
    KNIGHT(125, 55, 40, 25),
    THIEF(45, 115, 40, 30);

    private final Integer strength;
    private final Integer dexterity;
    private final Integer vitality;
    private final Integer energy;

    GuildType(Integer strength, Integer dexterity, Integer vitality, Integer energy) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.vitality = vitality;
        this.energy = energy;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getDexterity() {
        return dexterity;
    }

    public Integer getVitality() {
        return vitality;
    }

    public Integer getEnergy() {
        return energy;
    }
}