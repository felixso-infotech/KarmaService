package com.felixsoinfotech.karma.service.mapper;

import com.felixsoinfotech.karma.domain.*;
import com.felixsoinfotech.karma.service.dto.DimensionDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Dimension and its DTO DimensionDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface DimensionMapper extends EntityMapper<DimensionDTO, Dimension> {


    @Mapping(target = "activities", ignore = true)
    Dimension toEntity(DimensionDTO dimensionDTO);

    default Dimension fromId(Long id) {
        if (id == null) {
            return null;
        }
        Dimension dimension = new Dimension();
        dimension.setId(id);
        return dimension;
    }
}
