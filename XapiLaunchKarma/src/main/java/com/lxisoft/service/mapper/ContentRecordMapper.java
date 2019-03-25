package com.lxisoft.service.mapper;

import com.lxisoft.domain.*;
import com.lxisoft.service.dto.ContentRecordDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity ContentRecord and its DTO ContentRecordDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface ContentRecordMapper extends EntityMapper<ContentRecordDTO, ContentRecord> {



    default ContentRecord fromId(String id) {
        if (id == null) {
            return null;
        }
        ContentRecord contentRecord = new ContentRecord();
        contentRecord.setId(id);
        return contentRecord;
    }
}
