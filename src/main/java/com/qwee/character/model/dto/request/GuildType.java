package com.qwee.character.model.dto.request;

public enum GuildType {

    WIZZARD(1),
    KNIGHT(2),
    THIEF(3);

    private Integer index;

    GuildType(Integer guildTypeToGuildIndex) {
        this.index = guildTypeToGuildIndex;
    }

    public Integer databaseIndex() {
        return index;
    }

    public static GuildType entityType(Integer index) {
        switch (index) {
            case 1:
                return GuildType.WIZZARD;
            case 2:
                return GuildType.KNIGHT;
            case 3:
                return GuildType.THIEF;
            default:
                throw new IllegalArgumentException("There are no find this type");
        }
    }
}