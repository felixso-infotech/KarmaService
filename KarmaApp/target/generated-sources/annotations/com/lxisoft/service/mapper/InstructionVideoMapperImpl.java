package com.lxisoft.service.mapper;

import com.lxisoft.domain.InstructionVideo;
import com.lxisoft.service.dto.InstructionVideoDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-04-29T15:23:24+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class InstructionVideoMapperImpl implements InstructionVideoMapper {

    @Override
    public InstructionVideo toEntity(InstructionVideoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        InstructionVideo instructionVideo = new InstructionVideo();

        instructionVideo.setId( dto.getId() );
        instructionVideo.setFileName( dto.getFileName() );
        byte[] file = dto.getFile();
        if ( file != null ) {
            instructionVideo.setFile( Arrays.copyOf( file, file.length ) );
        }
        instructionVideo.setFileContentType( dto.getFileContentType() );

        return instructionVideo;
    }

    @Override
    public InstructionVideoDTO toDto(InstructionVideo entity) {
        if ( entity == null ) {
            return null;
        }

        InstructionVideoDTO instructionVideoDTO = new InstructionVideoDTO();

        instructionVideoDTO.setId( entity.getId() );
        instructionVideoDTO.setFileName( entity.getFileName() );
        byte[] file = entity.getFile();
        if ( file != null ) {
            instructionVideoDTO.setFile( Arrays.copyOf( file, file.length ) );
        }
        instructionVideoDTO.setFileContentType( entity.getFileContentType() );

        return instructionVideoDTO;
    }

    @Override
    public List<InstructionVideo> toEntity(List<InstructionVideoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<InstructionVideo> list = new ArrayList<InstructionVideo>( dtoList.size() );
        for ( InstructionVideoDTO instructionVideoDTO : dtoList ) {
            list.add( toEntity( instructionVideoDTO ) );
        }

        return list;
    }

    @Override
    public List<InstructionVideoDTO> toDto(List<InstructionVideo> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<InstructionVideoDTO> list = new ArrayList<InstructionVideoDTO>( entityList.size() );
        for ( InstructionVideo instructionVideo : entityList ) {
            list.add( toDto( instructionVideo ) );
        }

        return list;
    }
}
