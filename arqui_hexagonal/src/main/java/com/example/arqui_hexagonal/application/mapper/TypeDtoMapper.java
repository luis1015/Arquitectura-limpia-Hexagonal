package com.example.arqui_hexagonal.application.mapper;

import ch.qos.logback.core.pattern.color.ForegroundCompositeConverterBase;
import com.example.arqui_hexagonal.application.dto.TypeDto;
import com.example.arqui_hexagonal.domain.model.Type;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TypeDtoMapper{
    TypeDto toTypeDto(Type type);
}
