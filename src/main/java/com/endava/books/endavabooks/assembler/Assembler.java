package com.endava.books.endavabooks.assembler;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public interface Assembler<ENTITY, DTO> {

    ENTITY toEntity(DTO dto);
    default List<ENTITY> toEntities(List<DTO> dtos) {
        return dtos.stream().map(this::toEntity).collect(Collectors.toList());
    }

    DTO toDto(ENTITY entity);
    default List<DTO> toDtos(List<ENTITY> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    default Set<DTO> toDtos(Set<ENTITY> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toSet());
    }
}