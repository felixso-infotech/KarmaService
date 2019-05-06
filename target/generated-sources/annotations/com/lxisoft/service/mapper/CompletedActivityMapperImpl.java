package com.lxisoft.service.mapper;

import com.lxisoft.domain.Activity;
import com.lxisoft.domain.CompletedActivity;
import com.lxisoft.domain.RegisteredUser;
import com.lxisoft.service.dto.CompletedActivityDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-05-06T11:45:24+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class CompletedActivityMapperImpl implements CompletedActivityMapper {

    @Autowired
    private RegisteredUserMapper registeredUserMapper;
    @Autowired
    private ActivityMapper activityMapper;

    @Override
    public List<CompletedActivity> toEntity(List<CompletedActivityDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<CompletedActivity> list = new ArrayList<CompletedActivity>( dtoList.size() );
        for ( CompletedActivityDTO completedActivityDTO : dtoList ) {
            list.add( toEntity( completedActivityDTO ) );
        }

        return list;
    }

    @Override
    public List<CompletedActivityDTO> toDto(List<CompletedActivity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CompletedActivityDTO> list = new ArrayList<CompletedActivityDTO>( entityList.size() );
        for ( CompletedActivity completedActivity : entityList ) {
            list.add( toDto( completedActivity ) );
        }

        return list;
    }

    @Override
    public CompletedActivityDTO toDto(CompletedActivity completedActivity) {
        if ( completedActivity == null ) {
            return null;
        }

        CompletedActivityDTO completedActivityDTO = new CompletedActivityDTO();

        Long id = completedActivityActivityidId( completedActivity );
        if ( id != null ) {
            completedActivityDTO.setActivityId( id );
        }
        Long id1 = completedActivityRegisteredUserId( completedActivity );
        if ( id1 != null ) {
            completedActivityDTO.setRegisteredUserId( id1 );
        }
        completedActivityDTO.setId( completedActivity.getId() );

        return completedActivityDTO;
    }

    @Override
    public CompletedActivity toEntity(CompletedActivityDTO completedActivityDTO) {
        if ( completedActivityDTO == null ) {
            return null;
        }

        CompletedActivity completedActivity = new CompletedActivity();

        completedActivity.setRegisteredUser( registeredUserMapper.fromId( completedActivityDTO.getRegisteredUserId() ) );
        completedActivity.setActivityid( activityMapper.fromId( completedActivityDTO.getActivityId() ) );
        completedActivity.setId( completedActivityDTO.getId() );

        return completedActivity;
    }

    private Long completedActivityActivityidId(CompletedActivity completedActivity) {
        if ( completedActivity == null ) {
            return null;
        }
        Activity activityid = completedActivity.getActivityid();
        if ( activityid == null ) {
            return null;
        }
        Long id = activityid.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long completedActivityRegisteredUserId(CompletedActivity completedActivity) {
        if ( completedActivity == null ) {
            return null;
        }
        RegisteredUser registeredUser = completedActivity.getRegisteredUser();
        if ( registeredUser == null ) {
            return null;
        }
        Long id = registeredUser.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
