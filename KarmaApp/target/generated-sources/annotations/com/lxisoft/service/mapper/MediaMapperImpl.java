package com.lxisoft.service.mapper;

import com.lxisoft.domain.Activity;
import com.lxisoft.domain.CompletedActivity;
import com.lxisoft.domain.Media;
import com.lxisoft.service.dto.MediaDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-03T11:35:11+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class MediaMapperImpl implements MediaMapper {

    @Autowired
    private ActivityMapper activityMapper;
    @Autowired
    private CompletedActivityMapper completedActivityMapper;

    @Override
    public List<Media> toEntity(List<MediaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Media> list = new ArrayList<Media>( dtoList.size() );
        for ( MediaDTO mediaDTO : dtoList ) {
            list.add( toEntity( mediaDTO ) );
        }

        return list;
    }

    @Override
    public List<MediaDTO> toDto(List<Media> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MediaDTO> list = new ArrayList<MediaDTO>( entityList.size() );
        for ( Media media : entityList ) {
            list.add( toDto( media ) );
        }

        return list;
    }

    @Override
    public MediaDTO toDto(Media media) {
        if ( media == null ) {
            return null;
        }

        MediaDTO mediaDTO = new MediaDTO();

        Long id = mediaActivityId( media );
        if ( id != null ) {
            mediaDTO.setActivityId( id );
        }
        Long id1 = mediaCompletedActivityId( media );
        if ( id1 != null ) {
            mediaDTO.setCompletedActivityId( id1 );
        }
        mediaDTO.setId( media.getId() );
        mediaDTO.setFileName( media.getFileName() );
        byte[] file = media.getFile();
        if ( file != null ) {
            mediaDTO.setFile( Arrays.copyOf( file, file.length ) );
        }
        mediaDTO.setFileContentType( media.getFileContentType() );

        return mediaDTO;
    }

    @Override
    public Media toEntity(MediaDTO mediaDTO) {
        if ( mediaDTO == null ) {
            return null;
        }

        Media media = new Media();

        media.setActivity( activityMapper.fromId( mediaDTO.getActivityId() ) );
        media.setCompletedActivity( completedActivityMapper.fromId( mediaDTO.getCompletedActivityId() ) );
        media.setId( mediaDTO.getId() );
        media.setFileName( mediaDTO.getFileName() );
        byte[] file = mediaDTO.getFile();
        if ( file != null ) {
            media.setFile( Arrays.copyOf( file, file.length ) );
        }
        media.setFileContentType( mediaDTO.getFileContentType() );

        return media;
    }

    private Long mediaActivityId(Media media) {
        if ( media == null ) {
            return null;
        }
        Activity activity = media.getActivity();
        if ( activity == null ) {
            return null;
        }
        Long id = activity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long mediaCompletedActivityId(Media media) {
        if ( media == null ) {
            return null;
        }
        CompletedActivity completedActivity = media.getCompletedActivity();
        if ( completedActivity == null ) {
            return null;
        }
        Long id = completedActivity.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
