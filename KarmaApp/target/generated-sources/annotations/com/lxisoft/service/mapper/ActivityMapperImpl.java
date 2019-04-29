package com.lxisoft.service.mapper;

import com.lxisoft.domain.Activity;
import com.lxisoft.domain.InstructionVideo;
import com.lxisoft.domain.Media;
import com.lxisoft.service.dto.ActivityDTO;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-04-29T15:23:24+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class ActivityMapperImpl implements ActivityMapper {

    @Autowired
    private InstructionVideoMapper instructionVideoMapper;

    @Override
    public List<Activity> toEntity(List<ActivityDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<Activity> list = new ArrayList<Activity>( dtoList.size() );
        for ( ActivityDTO activityDTO : dtoList ) {
            list.add( toEntity( activityDTO ) );
        }

        return list;
    }

    @Override
    public List<ActivityDTO> toDto(List<Activity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ActivityDTO> list = new ArrayList<ActivityDTO>( entityList.size() );
        for ( Activity activity : entityList ) {
            list.add( toDto( activity ) );
        }

        return list;
    }

    @Override
    public ActivityDTO toDto(Activity activity) {
        if ( activity == null ) {
            return null;
        }

        ActivityDTO activityDTO = new ActivityDTO();

        Long id = activityInstructionVideoId( activity );
        if ( id != null ) {
            activityDTO.setInstructionVideoId( id );
        }
        activityDTO.setId( activity.getId() );
        activityDTO.setTitle( activity.getTitle() );
        activityDTO.setDescription( activity.getDescription() );
        activityDTO.setSuccessMessage( activity.getSuccessMessage() );
        activityDTO.setUrl( activity.getUrl() );
        Set<Media> set = activity.getFiles();
        if ( set != null ) {
            activityDTO.setFiles( new HashSet<Media>( set ) );
        }
        else {
            activityDTO.setFiles( null );
        }
        activityDTO.setInstructionVideo( activity.getInstructionVideo() );

        return activityDTO;
    }

    @Override
    public Activity toEntity(ActivityDTO activityDTO) {
        if ( activityDTO == null ) {
            return null;
        }

        Activity activity = new Activity();

        activity.setInstructionVideo( instructionVideoMapper.fromId( activityDTO.getInstructionVideoId() ) );
        activity.setId( activityDTO.getId() );
        activity.setTitle( activityDTO.getTitle() );
        activity.setDescription( activityDTO.getDescription() );
        activity.setSuccessMessage( activityDTO.getSuccessMessage() );
        activity.setUrl( activityDTO.getUrl() );

        return activity;
    }

    private Long activityInstructionVideoId(Activity activity) {
        if ( activity == null ) {
            return null;
        }
        InstructionVideo instructionVideo = activity.getInstructionVideo();
        if ( instructionVideo == null ) {
            return null;
        }
        Long id = instructionVideo.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
