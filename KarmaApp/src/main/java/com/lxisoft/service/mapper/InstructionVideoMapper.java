package com.lxisoft.service.mapper;

import com.lxisoft.domain.*;
import com.lxisoft.service.dto.InstructionVideoDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity InstructionVideo and its DTO InstructionVideoDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface InstructionVideoMapper extends EntityMapper<InstructionVideoDTO, InstructionVideo> {



    default InstructionVideo fromId(Long id) {
        if (id == null) {
            return null;
        }
        InstructionVideo instructionVideo = new InstructionVideo();
        instructionVideo.setId(id);
        return instructionVideo;
    }
}
