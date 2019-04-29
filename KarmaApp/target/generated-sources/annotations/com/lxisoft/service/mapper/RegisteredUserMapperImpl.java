package com.lxisoft.service.mapper;

import com.lxisoft.domain.Media;
import com.lxisoft.domain.RegisteredUser;
import com.lxisoft.service.dto.RegisteredUserDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-04-29T15:23:24+0530",
    comments = "version: 1.2.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
@Component
public class RegisteredUserMapperImpl implements RegisteredUserMapper {

    @Autowired
    private MediaMapper mediaMapper;

    @Override
    public List<RegisteredUser> toEntity(List<RegisteredUserDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RegisteredUser> list = new ArrayList<RegisteredUser>( dtoList.size() );
        for ( RegisteredUserDTO registeredUserDTO : dtoList ) {
            list.add( toEntity( registeredUserDTO ) );
        }

        return list;
    }

    @Override
    public List<RegisteredUserDTO> toDto(List<RegisteredUser> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RegisteredUserDTO> list = new ArrayList<RegisteredUserDTO>( entityList.size() );
        for ( RegisteredUser registeredUser : entityList ) {
            list.add( toDto( registeredUser ) );
        }

        return list;
    }

    @Override
    public RegisteredUserDTO toDto(RegisteredUser registeredUser) {
        if ( registeredUser == null ) {
            return null;
        }

        RegisteredUserDTO registeredUserDTO = new RegisteredUserDTO();

        Long id = registeredUserProfilePicId( registeredUser );
        if ( id != null ) {
            registeredUserDTO.setProfilePicId( id );
        }
        registeredUserDTO.setProfilePic( registeredUser.getProfilePic() );
        registeredUserDTO.setId( registeredUser.getId() );
        registeredUserDTO.setFirstName( registeredUser.getFirstName() );
        registeredUserDTO.setLastName( registeredUser.getLastName() );
        registeredUserDTO.setEmail( registeredUser.getEmail() );
        registeredUserDTO.setPhoneNumber( registeredUser.getPhoneNumber() );
        registeredUserDTO.setNoOfCoins( registeredUser.getNoOfCoins() );
        registeredUserDTO.setNoOfBronzeMedals( registeredUser.getNoOfBronzeMedals() );
        registeredUserDTO.setNoOfSilverMedals( registeredUser.getNoOfSilverMedals() );
        registeredUserDTO.setNoOfGoldMedals( registeredUser.getNoOfGoldMedals() );

        return registeredUserDTO;
    }

    @Override
    public RegisteredUser toEntity(RegisteredUserDTO registeredUserDTO) {
        if ( registeredUserDTO == null ) {
            return null;
        }

        RegisteredUser registeredUser = new RegisteredUser();

        registeredUser.setProfilePic( mediaMapper.fromId( registeredUserDTO.getProfilePicId() ) );
        registeredUser.setId( registeredUserDTO.getId() );
        registeredUser.setFirstName( registeredUserDTO.getFirstName() );
        registeredUser.setLastName( registeredUserDTO.getLastName() );
        registeredUser.setEmail( registeredUserDTO.getEmail() );
        registeredUser.setPhoneNumber( registeredUserDTO.getPhoneNumber() );
        registeredUser.setNoOfCoins( registeredUserDTO.getNoOfCoins() );
        registeredUser.setNoOfBronzeMedals( registeredUserDTO.getNoOfBronzeMedals() );
        registeredUser.setNoOfSilverMedals( registeredUserDTO.getNoOfSilverMedals() );
        registeredUser.setNoOfGoldMedals( registeredUserDTO.getNoOfGoldMedals() );

        return registeredUser;
    }

    private Long registeredUserProfilePicId(RegisteredUser registeredUser) {
        if ( registeredUser == null ) {
            return null;
        }
        Media profilePic = registeredUser.getProfilePic();
        if ( profilePic == null ) {
            return null;
        }
        Long id = profilePic.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
