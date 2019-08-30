package com.felixsoinfotech.karma.service.mapper;

import com.felixsoinfotech.karma.domain.*;
import com.felixsoinfotech.karma.service.dto.RegisteredUserDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity RegisteredUser and its DTO RegisteredUserDTO.
 */
@Mapper(componentModel = "spring", uses = {UserMapper.class})
public interface RegisteredUserMapper extends EntityMapper<RegisteredUserDTO, RegisteredUser> {

    @Mapping(source = "user.id", target = "userId")
    RegisteredUserDTO toDto(RegisteredUser registeredUser);

    @Mapping(source = "userId", target = "user")
    RegisteredUser toEntity(RegisteredUserDTO registeredUserDTO);

    default RegisteredUser fromId(Long id) {
        if (id == null) {
            return null;
        }
        RegisteredUser registeredUser = new RegisteredUser();
        registeredUser.setId(id);
        return registeredUser;
    }
}
