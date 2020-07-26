package com.nubnasir.newsstories.user.converter;

import com.nubnasir.newsstories.common.converter.ModelConverterInterface;
import com.nubnasir.newsstories.common.helper.DateTimeHelper;
import com.nubnasir.newsstories.user.model.dto.UserDto;
import com.nubnasir.newsstories.user.model.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

/**
 * Created by root on 9/12/18.
 */
@Component
public class UserModelConverter implements ModelConverterInterface<UserEntity, UserDto> {

    @Override
    public UserEntity convertDtoToEntity(UserDto o) {
        UserEntity userEntity = new UserEntity();
        userEntity.setId(o.getId());
        userEntity.setUserName(o.getUserName());
        userEntity.setFullName(o.getFullName());
        userEntity.setRegistrationDate(DateTimeHelper.convertStringToDate(o.getUserName()));
        userEntity.setLastLogInDate(DateTimeHelper.convertStringToDate(o.getLastLoginDate()));

        return userEntity;
    }

    @Override
    public UserDto convertEntityToDto(UserEntity o) {
        UserDto userDto = new UserDto();
        userDto.setId(o.getId());
        userDto.setUserName(o.getUserName());
        userDto.setFullName(o.getFullName());
        userDto.setRegistrationDate(DateTimeHelper.convertDateToString(o.getRegistrationDate()));
        userDto.setLastLoginDate(DateTimeHelper.convertDateToString(o.getLastLogInDate()));
        return userDto;
    }

    @Override
    public List<UserEntity> convertDtosToEntities(List<UserDto> userDtos) {
        return null;
    }

    @Override
    public List<UserDto> convertEntitiesToDtos(List<UserEntity> userEntities) {
        return null;
    }
}
