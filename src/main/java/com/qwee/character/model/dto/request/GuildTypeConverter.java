package com.qwee.character.model.dto.request;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = false)
public class GuildTypeConverter implements AttributeConverter<GuildType, Integer> {
    @Override
    public Integer convertToDatabaseColumn(GuildType guildType) {
        return guildType.databaseIndex();
    }

    @Override
    public GuildType convertToEntityAttribute(Integer integer) {
        return GuildType.entityType(integer);
    }
}
